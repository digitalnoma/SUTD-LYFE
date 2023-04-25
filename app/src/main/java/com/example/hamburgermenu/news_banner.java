package com.example.hamburgermenu;

public class news_banner {
    String newsTitle;
    String newsDate;

    public news_banner(String newsTitle, String newsDate) {
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }
}
