package com.example.a51;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class NewsDetailFragment extends Fragment {

    private TextView newsTitle;
    private TextView newsDescription;
    private RecyclerView rvRelatedNews;
    private RelatedNewsAdapter relatedNewsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        newsTitle = view.findViewById(R.id.textViewNewsTitle);
        newsDescription = view.findViewById(R.id.textViewNewsDescription);
        rvRelatedNews = view.findViewById(R.id.rvRelatedNews);

        // Set up RecyclerView
        rvRelatedNews.setLayoutManager(new LinearLayoutManager(getContext()));
        relatedNewsAdapter = new RelatedNewsAdapter(new ArrayList<>()); // Initially empty
        rvRelatedNews.setAdapter(relatedNewsAdapter);

        return view;
    }

    public void updateNewsDetails(News news, List<News> relatedNews) {
        newsTitle.setText(news.getTitle());
        newsDescription.setText(news.getSummary());

        // Update related news
        relatedNewsAdapter.relatedNews = relatedNews;
        relatedNewsAdapter.notifyDataSetChanged();
    }
}
