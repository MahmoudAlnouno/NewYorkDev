package com.android.newyorkdev.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.newyorkdev.R;
import com.android.newyorkdev.interfaces.RecyclerClick;
import com.android.newyorkdev.model.Article;
import com.android.newyorkdev.utils.ControllerFunction;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ItemViewHolder> {


    private Context mContext;
    private ArrayList<Article> arrayListArticles;
    private RecyclerClick recyclerClick;

    public MainActivityAdapter(Context mContext, ArrayList<Article> arrayListArticles, RecyclerClick recyclerClick) {
        this.mContext = mContext;
        this.arrayListArticles = arrayListArticles;
        this.recyclerClick = recyclerClick;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.popular_cell, parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Article article = arrayListArticles.get(position);
        holder.tvByline.setText(article.getByline());
        holder.tvTitle.setText(article.getTitle());
        holder.tvPublishedDate.setText(article.getPublishedDate());
        holder.tvType.setText(article.getType());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerClick.onClick(article, position);
            }
        });
        ControllerFunction.glideShowImage(mContext, article.getArrayListArticleMedia().get(0).getArrayListMediaMetadata().get(0).getUrl(), holder.ImgMovie);

    }

    @Override
    public int getItemCount() {
        return arrayListArticles.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvByline)
        TextView tvByline;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvType)
        TextView tvType;
        @BindView(R.id.tvPublishedDate)
        TextView tvPublishedDate;
        @BindView(R.id.imageView)
        ImageView ImgMovie;
        @BindView(R.id.cardView)
        CardView cardView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
