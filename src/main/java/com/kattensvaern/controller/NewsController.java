package com.kattensvaern.controller;

import com.kattensvaern.database.models.NewsArticle;
import com.kattensvaern.service.NewsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://127.0.0.1:5500"})
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/api/news")
    public List<NewsArticle> getAllNews() {
        return newsService.getAllNews();
    }


    @GetMapping("/api/news/{id}")
    public NewsArticle findNewsById(@PathVariable int id) {
        return newsService.findNewsById(id);
    }

    @PostMapping("/api/news")
    public void createNews(@RequestBody NewsArticle article) {
        newsService.createNews(article);
    }

    @PutMapping("/api/news/{id}")
    public void updateNews(@PathVariable int id, @RequestBody NewsArticle article) {
        article.setId(id);
        newsService.updateNews(article);
    }

    @DeleteMapping("/api/news/{id}")
    public void deleteNews(@PathVariable int id) {
        newsService.deleteNews(id);
    }

}