package com.android.newyorkdev.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GeneralResponse {
    private String status;
    private String copyright;

    @SerializedName("results")
    private ArrayList<Article> arrayListAraArticles;

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public ArrayList<Article> getArrayListAraArticles() {
        return arrayListAraArticles;
    }
}
