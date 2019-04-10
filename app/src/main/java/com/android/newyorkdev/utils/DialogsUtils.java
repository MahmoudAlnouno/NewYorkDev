package com.android.newyorkdev.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogsUtils {

    private ProgressDialog progressDialog;


    public DialogsUtils(Context context, boolean withProgress, String Msg) {
        if (withProgress) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setProgressStyle(android.R.style.Theme_DeviceDefault_Light_DarkActionBar);
            progressDialog.setMessage(Msg);
            startProgressDialog();
        }
    }

    public DialogsUtils(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(android.R.style.Theme_DeviceDefault_Light_DarkActionBar);
        progressDialog.setMessage("Loading..");
        startProgressDialog();

    }

    public void startProgressDialog() {
        if (progressDialog != null) {
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }

    public void endProgressDialog() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }
}
