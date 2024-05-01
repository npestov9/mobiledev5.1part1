package com.example.a51;

public class News {
    private String title;
    private String summary;
    private String imageUrl;

    public News(String title, String summary, String imageUrl) {
        this.title = title;
        this.summary = summary;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
