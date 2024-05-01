package com.example.a51;

public class Story {
    private String title;
    private String imageUrl;

    public Story(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
