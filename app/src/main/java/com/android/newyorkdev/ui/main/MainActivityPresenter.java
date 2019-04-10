package com.android.newyorkdev.ui.main;


import com.android.newyorkdev.api.APICallBack;
import com.android.newyorkdev.api.RequestFactory;
import com.android.newyorkdev.interfaces.RecyclerClick;
import com.android.newyorkdev.model.Article;
import com.android.newyorkdev.ui.articlesdeatils.ArticlesDetailsActivity;

import java.util.ArrayList;

/**
 * Created by alnounom on 23/12/2018.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter<MainActivityContract.View> {

    MainActivityContract.View mView;

    @Override
    public void attachView(MainActivityContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void loadData(int period) {
        new RequestFactory(mView.getMyContext(), new APICallBack<ArrayList<Article>>() {
            @Override
            public void onSuccess(ArrayList<Article> response) {
                mView.onDataLoaded(response);
            }

            @Override
            public void onError(String error) {
            }
        }).getPopularMovie(period);
    }


}
