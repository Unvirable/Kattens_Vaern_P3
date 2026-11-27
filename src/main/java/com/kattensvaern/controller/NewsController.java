package com.kattensvaern.controller;

import com.kattensvaern.database.models.NewsArticle;
import com.kattensvaern.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
        try {
            if (id <= 0) {
                System.out.println("ERROR: Invalid news ID");
                return null;
            }

            return newsService.findNewsById(id);

        } catch (Exception e) {
            System.out.println("ERROR: Failed to find news article");
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/api/news")
    public void createNews(@RequestBody NewsArticle article) {
        try {
            if (article == null ||
                    article.getTitle() == null || article.getTitle().isBlank() ||
                    article.getContent() == null || article.getContent().isBlank()) {

                System.out.println("ERROR: Invalid news article");
                return;
            }

            newsService.createNews(article);

        } catch (Exception e) {
            System.out.println("ERROR: Failed to create news article");
            e.printStackTrace();
        }
    }

    @PutMapping("/api/news/{id}")
    public void updateNews(@PathVariable int id, @RequestBody NewsArticle article) {
        try {
            if (id <= 0 || article == null ||
                    article.getTitle() == null || article.getTitle().isBlank() ||
                    article.getContent() == null || article.getContent().isBlank()) {

                System.out.println("ERROR: Invalid news information");
                return;
            }

            article.setId(id);
            newsService.updateNews(article);

        } catch (Exception e) {
            System.out.println("ERROR: Failed to update news article");
            e.printStackTrace();
        }
    }

    @DeleteMapping("/api/news/{id}")
    public void deleteNews(@PathVariable int id) {
        try {
            if (id <= 0) {
                System.out.println("ERROR: Invalid news ID");
                return;
            }

            newsService.deleteNews(id);

        } catch (Exception e) {
            System.out.println("ERROR: Failed to delete news article");
            e.printStackTrace();
        }
    }

}