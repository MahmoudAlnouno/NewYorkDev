package com.android.newyorkdev.ui.base;

/**
 * Created by alnouno on 25/01/2018.
 * MAIN PRESENTER WHICH IS NEEDED TO IMPLEMENT ON THE EXISTING PRESENTER
 *
 * @Param V IS GENERIC FOR APPLYING ANY PRESENTER TYPE WHAT EVER THE TYPE OF IT IS.
 */
public interface BasePresenter<V> {
    /**
     * alerting the presenter about the view that will work on it
     * this method will assign the view needed that will be created
     * from the activity / fragment - for using in methods needed
     * for the presenter of that activity / fragment
     *
     * @param view
     */
    void attachView(V view);

    /**
     * alerting the presenter that the view is no longer available
     */
    void detachView();
}
