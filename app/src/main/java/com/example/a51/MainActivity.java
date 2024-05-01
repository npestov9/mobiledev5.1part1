package com.example.a51;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
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

        // Assuming constructors that handle data initialization
        topStoriesAdapter = new TopStoriesAdapter(storiesList);
        recyclerViewTopStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTopStories.setAdapter(topStoriesAdapter);

        newsAdapter = new NewsAdapter(newsList, this);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNews.setAdapter(newsAdapter);

        // Prepare and attach the detail fragment initially if needed
        if (savedInstanceState == null) {
            NewsDetailFragment fragment = new NewsDetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.newsDetailFragmentContainer, fragment, "NEWS_DETAIL_FRAGMENT")
                    .commit();
        }
    }

    private void initializeData() {
        storiesList = new ArrayList<>();
        newsList = new ArrayList<>();

        // Initialize with sample top stories data
        storiesList.add(new Story("Top Story 1", null));
        storiesList.add(new Story("Top Story 2", null));
        storiesList.add(new Story("Top Story 2", null));
        storiesList.add(new Story("Top Story 2", null));
        storiesList.add(new Story("Top Story 2", null));


        // Initialize with sample news data
        newsList.add(new News("News Title 1", "Summary 1", null));
        newsList.add(new News("News Title 2", "Summary 2", null));
        newsList.add(new News("News Title 1", "Summary 1", null));
        newsList.add(new News("News Title 2", "Summary 2", null));
        newsList.add(new News("News Title 1", "Summary 1", null));
        newsList.add(new News("News Title 2", "Summary 2", null));

        // Add more news as needed
    }

    @Override
    public void onItemClick(News news) {
        NewsDetailFragment fragment = (NewsDetailFragment) getSupportFragmentManager()
                .findFragmentByTag("NEWS_DETAIL_FRAGMENT");
        if (fragment != null) {
            fragment.updateNewsDetails(news);
        }
    }
}
