package com.example.a51;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTopStories;
    private RecyclerView recyclerViewNews;
    private TopStoriesAdapter topStoriesAdapter;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTopStories = findViewById(R.id.recyclerViewTopStories);
        recyclerViewNews = findViewById(R.id.recyclerViewNews);

        // Setting the adapter for top stories
        topStoriesAdapter = new TopStoriesAdapter(); // Assume you have a default constructor that handles data
        recyclerViewTopStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTopStories.setAdapter(topStoriesAdapter);

        // Setting the adapter for news
        newsAdapter = new NewsAdapter(); // Assume you have a default constructor that handles data
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNews.setAdapter(newsAdapter);
    }
}

