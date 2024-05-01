package com.example.a51;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<News> newsList;
    private OnItemClickListener listener;

    public NewsAdapter(List<News> newsList, OnItemClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(News news);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleView, summaryView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewNews);
            titleView = itemView.findViewById(R.id.textViewNewsTitle);
            summaryView = itemView.findViewById(R.id.textViewNewsSummary);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(newsList.get(position));
                    }
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.titleView.setText(news.getTitle());
        holder.summaryView.setText(news.getSummary());
        // Set image if available
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
