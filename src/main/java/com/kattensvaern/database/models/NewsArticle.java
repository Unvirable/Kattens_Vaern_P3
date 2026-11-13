package com.kattensvaern.database.models;

import java.time.LocalDate;

public class NewsArticle {

    private int id;
    private String title;
    private String content;
    private LocalDate date;
    private String imageUrl;

    public NewsArticle(int id, String title, String content, LocalDate date, String imageUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}