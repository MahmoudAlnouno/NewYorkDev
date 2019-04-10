package com.android.newyorkdev.ui.articlesdeatils;

import com.android.newyorkdev.ui.base.BasePresenter;
import com.android.newyorkdev.ui.base.BaseView;
import com.android.newyorkdev.ui.main.MainActivityContract;

public interface ArticlesDetailsContract {
    interface View extends BaseView<MainActivityContract.Presenter> {
        void fillData();
    }

    interface Presenter<View> extends BasePresenter<View> {
    }
}
