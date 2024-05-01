package com.example.a51;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList; // Import ArrayList

import java.util.Arrays; // Import Arrays
import java.util.List;

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

        // Sample data for top stories
        List<Story> sampleTopStories = Arrays.asList(
                new Story("Story 1", "http://example.com/story1.jpg"),
                new Story("Story 2", "http://example.com/story2.jpg"),
                new Story("Story 3", "http://example.com/story3.jpg"),
                new Story("Story 4", "http://example.com/story3.jpg"),
                new Story("Story 5", "http://example.com/story3.jpg"),
                new Story("Story 6", "http://example.com/story3.jpg"),
                new Story("Story 7", "http://example.com/story3.jpg")
        );

        // Sample data for news
        List<News> sampleNews = Arrays.asList(
                new News("News 1", "Summary 1", "http://example.com/news1.jpg"),
                new News("News 2", "Summary 2", "http://example.com/news2.jpg"),
                new News("News 3", "Summary 3", "http://example.com/news3.jpg"),
                new News("News 4", "Summary 4", "http://example.com/news3.jpg"),
                new News("News 5", "Summary 5", "http://example.com/news3.jpg"),
                new News("News 6", "Summary 6", "http://example.com/news3.jpg"),
                new News("News 2", "Summary 2", "http://example.com/news2.jpg"),
                new News("News 3", "Summary 3", "http://example.com/news3.jpg"),
                new News("News 4", "Summary 4", "http://example.com/news3.jpg"),
                new News("News 5", "Summary 5", "http://example.com/news3.jpg")

        );

        // Initialize adapters with sample data
        topStoriesAdapter = new TopStoriesAdapter(sampleTopStories);
        recyclerViewTopStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTopStories.setAdapter(topStoriesAdapter);

        newsAdapter = new NewsAdapter(sampleNews);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewNews.setAdapter(newsAdapter);
    }
}

