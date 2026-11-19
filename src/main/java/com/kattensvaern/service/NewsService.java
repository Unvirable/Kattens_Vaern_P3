package com.kattensvaern.service;

import com.kattensvaern.database.DAO.NewsDAO;
import com.kattensvaern.database.models.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsDAO newsDAO;

    public NewsService(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    public List<NewsArticle> getAllNews() {
        return newsDAO.getAllNews();
    }

    public NewsArticle findNewsById(int id) {
        return newsDAO.findNewsById(id);
    }

    public void createNews(NewsArticle article) {
        newsDAO.CreateNews(article);
    }

    public void updateNews(NewsArticle article) {
        newsDAO.UpdateNews(article);
    }

    public void deleteNews(int id) {
        newsDAO.DeleteNews(id);
    }


}
