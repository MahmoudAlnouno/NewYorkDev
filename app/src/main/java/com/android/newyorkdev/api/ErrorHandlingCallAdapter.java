/*
 * Copyright (c) 2016. created and edited by Khalid Kadamani
 */

package com.android.newyorkdev.api;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by alnounom on 23/08/2016.
 */
public class ErrorHandlingCallAdapter {
    /**
     * A callback which offers granular callbacks for various conditions.
     */
    public interface MyCallback<T> {
        void onResult(T response);

        void onError(String spineError);

        void unexpectedError(Call<T> call, Throwable t);
    }

    public interface MyCall<T> {
        void cancel();

        void enqueue(MyCallback<T> callback);

        MyCall<T> clone();

        // Left as an exercise for the reader...
        // TODO MyResponse<T> execute() throws MyHttpException;
        Response<T> execute() throws IOException;
    }


    public static class ErrorHandlingCallAdapterFactory extends CallAdapter.Factory {

        @Override
        public CallAdapter<MyCall<?>, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
            if (getRawType(returnType) != MyCall.class) {
                return null;
            }
            Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);
            Executor executor = retrofit.callbackExecutor();
            //return new MyCallAdapter<>(observableType, executor);
            return new CallAdapter<MyCall<?>, Object>() {
                @Override
                public Type responseType() {
                    return observableType;
                }

                @Override
                public Object adapt(Call<MyCall<?>> call) {
                    return new MyCallAdapter<>(call, executor);
                }
            };

        }
    }

    /**
     * Adapts a {@link Call} to {@link MyCall}.
     */
    static class MyCallAdapter<T> implements MyCall<T> {
        private final Call<T> call;
        private final Executor callbackExecutor;
        Handler mainHandler;

        MyCallAdapter(Call<T> call, Executor callbackExecutor) {
            this.call = call;
            this.callbackExecutor = callbackExecutor;
            mainHandler = new Handler(Looper.getMainLooper());
        }

        @Override
        public void cancel() {
            call.cancel();
        }

        @Override
        public void enqueue(final MyCallback<T> callback) {
            call.enqueue(new Callback<T>() {
                @Override
                public void onResponse(final Call<T> call, final Response<T> response) {
                    // TODO if 'callbackExecutor' is not null, the 'callback' methods should be executed
                    // on that executor by submitting a Runnable. This is left as an exercise for the reader.

                    final int code = response.code();

                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (code >= 200 && code < 300) {
                                callback.onResult(response.body());
                            } else
                                callback.onError("onResponse error");
                        }
                    });

                }

                @Override
                public void onFailure(final Call<T> call, final Throwable t) {

                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.unexpectedError(call, t);
                        }
                    });

                }
            });
        }

        @Override
        public MyCall<T> clone() {
            return new MyCallAdapter<>(call.clone(), callbackExecutor);
        }


        @Override
        public Response<T> execute() throws IOException {
            return call.execute();
        }
    }
}
