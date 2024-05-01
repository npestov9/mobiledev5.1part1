package com.example.a51;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class NewsDetailFragment extends Fragment {

    private TextView newsTitle;
    private TextView newsDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        newsTitle = view.findViewById(R.id.textViewNewsTitle);
        newsDescription = view.findViewById(R.id.textViewNewsDescription);
        return view;
    }

    public void updateNewsDetails(News news) {
        Log.d("NewsDetailFragment", "Updating news details for: " + news.getTitle());
        if (newsTitle != null && newsDescription != null) {
            newsTitle.setText(news.getTitle());
            newsDescription.setText(news.getSummary());
        }
    }
}

