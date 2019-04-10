package com.android.newyorkdev.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ArticleMedia implements Serializable {

    @SerializedName("type")
    private String type;
    @SerializedName("media-metadata")
    private ArrayList<MediaMetadata> arrayListMediaMetadata;

    public String getType() {
        return type;
    }

    public ArrayList<MediaMetadata> getArrayListMediaMetadata() {
        return arrayListMediaMetadata;
    }
}
