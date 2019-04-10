package com.android.newyorkdev.ui.main;

import com.android.newyorkdev.model.Article;
import com.android.newyorkdev.ui.base.BasePresenter;
import com.android.newyorkdev.ui.base.BaseView;

import java.util.ArrayList;

public interface MainActivityContract {
    interface View extends BaseView<Presenter> {

        void onDataLoaded(ArrayList<Article>arrayListArticles);
    }

    interface Presenter<View> extends BasePresenter<View> {
        void loadData(int period);
    }
}
