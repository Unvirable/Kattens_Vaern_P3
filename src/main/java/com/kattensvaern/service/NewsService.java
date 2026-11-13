package com.kattensvaern.service;

import com.kattensvaern.DAO.NewsDAO;
import com.kattensvaern.model.NewsArticle;
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
}
