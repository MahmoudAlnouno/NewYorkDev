package com.android.newyorkdev.ui.main;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;

import com.android.newyorkdev.R;
import com.android.newyorkdev.interfaces.RecyclerClick;
import com.android.newyorkdev.model.Article;
import com.android.newyorkdev.ui.adapter.MainActivityAdapter;
import com.android.newyorkdev.ui.articlesdeatils.ArticlesDetailsActivity;
import com.android.newyorkdev.ui.base.BaseActivity;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityContract.View, RecyclerClick<Article> {

    @BindView(R.id.recyclerPopular)
    RecyclerView recyclerPopular;
    private ArrayList<Article> arrayListArticles = new ArrayList<>();

    @Override
    protected MainActivityPresenter getPresenter() {
        return new MainActivityPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Context getMyContext() {
        return this;
    }

    @Override
    public void setUp() {
        super.setUp();
        mPresenter.loadData(1);
    }

    @Override
    public void onDataLoaded(ArrayList<Article> arrayListArticles) {
        this.arrayListArticles = arrayListArticles;
        MainActivityAdapter mainActivityAdapter
                = new MainActivityAdapter(getMyContext(), arrayListArticles, this);
        recyclerPopular.setAdapter(mainActivityAdapter);
        recyclerPopular.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.period_1:
                mPresenter.loadData(1);
                return true;
            case R.id.period_7:
                mPresenter.loadData(7);
                return true;
            case R.id.period_30:
                mPresenter.loadData(30);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(Article article, int position) {
        startActivity(ArticlesDetailsActivity.getStartIntent(article, getMyContext()));
    }
}
