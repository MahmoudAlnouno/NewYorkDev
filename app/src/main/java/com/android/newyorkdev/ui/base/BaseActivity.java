package com.android.newyorkdev.ui.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;

/**
 * Created by alnounom .
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adjustMainTitle();
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        if (mPresenter == null)
            mPresenter = getPresenter();
        mPresenter.attachView(this);

        setUp();
    }

    protected abstract T getPresenter();

    protected abstract int getLayoutId();

    public void setUp() {

    }

    public void adjustMainTitle() {

    }

    public void showMessageToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }


    /**
     * Method of starting fragment from the activity container (frameContainer
     *
     * @param fragmentClass
     */
    public void startFragment(Fragment fragmentClass) {
        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
        //fragmentManager.replace(R.id.frameContainer, fragmentClass).addToBackStack(fragmentClass.getClass().getSimpleName());
        fragmentManager.commit();
    }
}
