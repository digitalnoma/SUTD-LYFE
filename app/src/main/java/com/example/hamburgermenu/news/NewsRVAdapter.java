package com.example.hamburgermenu.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamburgermenu.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

// wrapper class as well
public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {
    private ArrayList<Articles> arrayListArticles;
    private Context context;

    public NewsRVAdapter(ArrayList<Articles> arrayListArticles, Context context1) {
        this.arrayListArticles = arrayListArticles;
        this.context = context1;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Articles articles = arrayListArticles.get(position);
        holder.subTitleTV.setText(articles.getDescription());
        holder.titleTV.setText(articles.getTitle());
        Picasso.get().load(articles.getUrlToImage()).into(holder.newsIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i = new Intent(context, NewsDetailsActivity.class);
              i.putExtra("title", articles.getTitle());
              i.putExtra("content", articles.getTitle());
              i.putExtra("desc", articles.getTitle());
              i.putExtra("image", articles.getTitle());
              i.putExtra("url", articles.getTitle());
              context.startActivity(i);
          }
        });
    }

    @Override
    public int getItemCount(){
        return arrayListArticles.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV, subTitleTV;
        private ImageView newsIV;
        public ViewHolder(@NonNull View itemview) {
            super(itemview);
            titleTV = itemView.findViewById(R.id.TVNewsHeading);
            subTitleTV = itemView.findViewById(R.id.SubTitle);
            newsIV = itemView.findViewById(R.id.IVNews);
        }
    }
}
