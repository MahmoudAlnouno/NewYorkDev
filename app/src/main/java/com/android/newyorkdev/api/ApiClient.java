package com.android.newyorkdev.api;

import com.android.newyorkdev.BuildConfig;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    public static String token = "";
    private static int timeOutDB = 10;
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient() {
        String url = BuildConfig.URL_ENDPOINT;
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new ErrorHandlingCallAdapter.ErrorHandlingCallAdapterFactory())
                .build();
        return retrofit;

    }
}
