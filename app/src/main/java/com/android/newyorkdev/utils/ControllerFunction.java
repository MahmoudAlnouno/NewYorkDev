package com.android.newyorkdev.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class ControllerFunction {


    public static void glideShowImage(Context mContext, String url, ImageView img) {
        Glide.with(mContext)
                .load(url)
                .into(img);

    }
}
