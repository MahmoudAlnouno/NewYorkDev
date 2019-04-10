package com.android.newyorkdev.api;

import android.content.Context;

import com.android.newyorkdev.BuildConfig;
import com.android.newyorkdev.model.GeneralResponse;
import com.android.newyorkdev.utils.DialogsUtils;

import retrofit2.Call;

public class RequestFactory extends DialogsUtils {

    APICallBack apiResult;
    APIManager apiManager;


    public RequestFactory(Context context, APICallBack apiResult) {
        super(context);
        this.apiResult = apiResult;
        apiManager = ApiClient.getRetrofitClient().create(APIManager.class);
    }

    public void getPopularMovie(int period) {
        ErrorHandlingCallAdapter.MyCall<GeneralResponse> getPopularArticles =
                apiManager.getPopularArticles(period, BuildConfig.API_KEY);

        getPopularArticles.enqueue(new ErrorHandlingCallAdapter.MyCallback<GeneralResponse>() {
            @Override
            public void onResult(GeneralResponse response) {
                endProgressDialog();
                apiResult.onSuccess(response.getArrayListAraArticles());
            }

            @Override
            public void onError(String spineError) {
                endProgressDialog();
            }

            @Override
            public void unexpectedError(Call<GeneralResponse> call, Throwable t) {
                endProgressDialog();
            }
        });
    }
}



