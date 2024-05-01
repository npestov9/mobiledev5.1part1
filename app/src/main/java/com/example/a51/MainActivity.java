package com.example.a51;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewsAdapter.OnItemClickListener {

    private RecyclerView recyclerViewTopStories;
    private RecyclerView recyclerViewNews;
    private TopStoriesAdapter topStoriesAdapter;
    private NewsAdapter newsAdapter;
    private ArrayList<News> newsList;
    private ArrayList<Story> storiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();

        recyclerViewTopStories = findViewById(R.id.recyclerViewTopStories);
        recyclerViewNews = findViewById(R.id.recyclerViewNews);

        // Setting up the adapter with the list of stories
        topStoriesAdapter = new TopStoriesAdapter(storiesList);
        recyclerViewTopStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTopStories.setAdapter(topStoriesAdapter);

        // Setting up the adapter with the list of news
        newsAdapter = new NewsAdapter(newsList, this);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNews.setAdapter(newsAdapter);
    }

    private void initializeData() {
        storiesList = new ArrayList<>();
        newsList = new ArrayList<>();

        // Initialize with sample top stories data
        storiesList.add(new Story("Top Story 1", null));
        storiesList.add(new Story("Top Story 2", null));
        storiesList.add(new Story("Top Story 3", null));
        storiesList.add(new Story("Top Story 4", null));


        // Initialize with sample news data
        newsList.add(new News("News Title 1", "Summary 1", null));
        newsList.add(new News("News Title 2", "Summary 2", null));
        newsList.add(new News("News Title 3", "Summary 1", null));
        newsList.add(new News("News Title 4", "Summary 2", null));

    }

    @Override
    public void onItemClick(News news) {
        // Here you update your detailed view:
        // For example, set TextViews for title, summary, etc.
        Toast.makeText(this, "Clicked: " + news.getTitle(), Toast.LENGTH_SHORT).show();

    }
}
