package com.example.a51;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<News> newsList; // Assume News is a model class you have defined

    public NewsAdapter(){

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView titleView;
        private final TextView summaryView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageViewNews);
            titleView = view.findViewById(R.id.textViewNewsTitle);
            summaryView = view.findViewById(R.id.textViewNewsSummary);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTitleView() {
            return titleView;
        }

        public TextView getSummaryView() {
            return summaryView;
        }
    }

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        News newsItem = newsList.get(position);
        viewHolder.getTitleView().setText(newsItem.getTitle());
        viewHolder.getSummaryView().setText(newsItem.getSummary());
        // You can also set the image here using an image loading library
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
