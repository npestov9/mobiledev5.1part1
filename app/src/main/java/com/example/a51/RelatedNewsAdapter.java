package com.example.a51;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.RelatedNewsViewHolder> {

    private String[] titles = {"Related News 1", "Related News 2", "Related News 3", "Related News 4", "Related News 5"};
//    private int[] images = {R.drawable.related_news_1, R.drawable.related_news_2, R.drawable.related_news_3, R.drawable.related_news_4, R.drawable.related_news_5};

    @Override
    public RelatedNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_related_news, parent, false);
        return new RelatedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RelatedNewsViewHolder holder, int position) {
        holder.title.setText(titles[position]);
//        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class RelatedNewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;

        RelatedNewsViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewRelatedNews);
            title = itemView.findViewById(R.id.textViewRelatedNewsTitle);
        }
    }
}
