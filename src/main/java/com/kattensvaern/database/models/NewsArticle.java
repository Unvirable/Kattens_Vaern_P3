package com.kattensvaern.database.models;

import java.time.LocalDate;

public class NewsArticle {

    private int id;
    private String title;
    private String content;
    private LocalDate date;
    private String imageUrl;
    private String publishedBy;


    public NewsArticle(int id, String title, String content, LocalDate date, String publishedBy, String imageUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.publishedBy = publishedBy;
        this.imageUrl = imageUrl;
    }
    public NewsArticle(int id, String title, String content, LocalDate date, String publishedBy) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.publishedBy = publishedBy;
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

    public String getPublishedBy() {
        return publishedBy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPublishedBy(String publishedBy) {
        this.publishedBy = publishedBy;
    }

}