/*
 * Copyright (c) 2016. created and edited by Khalid Kadamani
 */

package com.android.newyorkdev.api;

import com.android.newyorkdev.model.GeneralResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIManager {

    @GET("viewed/{period}.json")
    ErrorHandlingCallAdapter.MyCall<GeneralResponse> getPopularArticles(@Path("period") int period,
                                                                        @Query("api-key") String apiKey);
}
