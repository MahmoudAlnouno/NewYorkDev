package com.android.newyorkdev.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Article implements Serializable {
    @SerializedName("byline")
    private String byline;
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;
    @SerializedName("published_date")
    private String publishedDate;


    @SerializedName("abstract")
    private String strAbstract;
    @SerializedName("section")
    private String section;

    public String getByline() {
        return byline;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getStrAbstract() {
        return strAbstract;
    }

    public String getSection() {
        return section;
    }

    public ArrayList<ArticleMedia> getArrayListArticleMedia() {
        return arrayListArticleMedia;
    }

    @SerializedName("media")
    ArrayList<ArticleMedia> arrayListArticleMedia;




}
