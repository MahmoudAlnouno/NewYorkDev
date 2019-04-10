package com.android.newyorkdev.api;

public interface APICallBack<T> {

    void onSuccess(T response);

    void onError(String error);

}
