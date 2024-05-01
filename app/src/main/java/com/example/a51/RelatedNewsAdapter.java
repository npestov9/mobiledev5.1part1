package com.example.a51;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.ViewHolder> {

    List<News> relatedNews;

    public RelatedNewsAdapter(List<News> relatedNews) {
        this.relatedNews = relatedNews;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_related_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = relatedNews.get(position);
        holder.newsTitle.setText(news.getTitle());
    }

    @Override
    public int getItemCount() {
        return relatedNews != null ? relatedNews.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.textViewRelatedNewsTitle);
        }
    }
}
