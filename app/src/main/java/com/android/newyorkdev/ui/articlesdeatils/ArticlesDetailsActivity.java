package com.android.newyorkdev.ui.articlesdeatils;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.newyorkdev.R;
import com.android.newyorkdev.interfaces.RecyclerClick;
import com.android.newyorkdev.model.Article;
import com.android.newyorkdev.ui.base.BaseActivity;
import com.android.newyorkdev.utils.ControllerFunction;

import java.io.Serializable;

import butterknife.BindView;

public class ArticlesDetailsActivity extends BaseActivity<ArticlesDetailsPresenter> implements ArticlesDetailsContract.View{
    @BindView(R.id.tvByline)
    TextView tvByline;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvType)
    TextView tvType;
    @BindView(R.id.tvAbstract)
    TextView tvAbstract;

    @BindView(R.id.tvPublishedDate)
    TextView tvPublishedDate;
    @BindView(R.id.imageView)
    ImageView imgMovie;

    Article objArticle;

    public static Intent getStartIntent(Article objArticle, Context context) {
        Intent intent = new Intent(context, ArticlesDetailsActivity.class);
        intent.putExtra("obj", (Serializable) objArticle);

        return intent;

    }

    @Override
    protected ArticlesDetailsPresenter getPresenter() {
        return new ArticlesDetailsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_articles_details;
    }

    @Override
    public Context getMyContext() {
        return this;
    }

    @Override
    public void setUp() {

        super.setUp();
        objArticle = (Article) getIntent().getSerializableExtra("obj");
        fillData();
    }

    @Override
    public void fillData() {
        tvAbstract.setText(objArticle.getStrAbstract());
        tvByline.setText(objArticle.getByline());
        tvPublishedDate.setText(objArticle.getPublishedDate());
        tvType.setText(objArticle.getType());
        tvTitle.setText(objArticle.getTitle());
        ControllerFunction.glideShowImage(getMyContext(), objArticle.getArrayListArticleMedia().get(0).getArrayListMediaMetadata().get(2).getUrl(), imgMovie);
    }

}
