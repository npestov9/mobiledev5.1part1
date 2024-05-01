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
    private boolean isDetailFragmentVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();

        recyclerViewTopStories = findViewById(R.id.recyclerViewTopStories);
        recyclerViewNews = findViewById(R.id.recyclerViewNews);

        topStoriesAdapter = new TopStoriesAdapter(storiesList);
        recyclerViewTopStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTopStories.setAdapter(topStoriesAdapter);

        newsAdapter = new NewsAdapter(newsList, this);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNews.setAdapter(newsAdapter);

        if (savedInstanceState == null) {
            NewsDetailFragment fragment = new NewsDetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.newsDetailFragmentContainer, fragment, "NEWS_DETAIL_FRAGMENT")
                    .hide(fragment)
                    .commit();
        }
    }

    private void initializeData() {
        storiesList = new ArrayList<>();
        newsList = new ArrayList<>();

        storiesList.add(new Story("Top Story 1", null));
        storiesList.add(new Story("Top Story 2", null));
        storiesList.add(new Story("Top Story 3", null));
        storiesList.add(new Story("Top Story 4", null));
        storiesList.add(new Story("Top Story 5", null));

        newsList.add(new News("News Title 1", "Summary 1", null));
        newsList.add(new News("News Title 2", "Summary 2", null));
        newsList.add(new News("News Title 3", "Summary 3", null));
        newsList.add(new News("News Title 4", "Summary 4", null));
        newsList.add(new News("News Title 5", "Summary 5", null));
    }

    @Override
    public void onItemClick(News news) {
        NewsDetailFragment fragment = (NewsDetailFragment) getSupportFragmentManager().findFragmentByTag("NEWS_DETAIL_FRAGMENT");
        if (fragment != null) {
            fragment.updateNewsDetails(news);
            // Toggle fragment visibility
            if (fragment.isVisible()) {
                getSupportFragmentManager().beginTransaction().hide(fragment).commit();
            } else {
                getSupportFragmentManager().beginTransaction().show(fragment).commit();
            }
        } else {
            // Initially add and show the fragment
            fragment = new NewsDetailFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.newsDetailFragmentContainer, fragment, "NEWS_DETAIL_FRAGMENT");
            transaction.commit();
            getSupportFragmentManager().executePendingTransactions(); // Ensure the fragment is added immediately
            fragment.updateNewsDetails(news);
            getSupportFragmentManager().beginTransaction().show(fragment).commit();
        }
    }


    @Override
    public void onBackPressed() {
        NewsDetailFragment fragment = (NewsDetailFragment) getSupportFragmentManager().findFragmentByTag("NEWS_DETAIL_FRAGMENT");
        if (fragment != null && fragment.isVisible()) {
            getSupportFragmentManager().beginTransaction().hide(fragment).commit();
        } else {
            super.onBackPressed();  // Default back button action
        }
    }

}
