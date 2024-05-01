package com.example.a51;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsDetailFragment extends Fragment {

    private RecyclerView recyclerViewRelatedNews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        recyclerViewRelatedNews = view.findViewById(R.id.rvRelatedNews);
        recyclerViewRelatedNews.setLayoutManager(new LinearLayoutManager(getContext()));
        RelatedNewsAdapter adapter = new RelatedNewsAdapter();
        recyclerViewRelatedNews.setAdapter(adapter);
        return view;
    }
}
