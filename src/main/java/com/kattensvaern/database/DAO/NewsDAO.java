package com.kattensvaern.database.DAO;

import com.kattensvaern.database.models.NewsArticle;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NewsDAO {

    private final DataSource dataSource;

    public NewsDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<NewsArticle> getAllNews() {

        String sql = "SELECT news_article_id, title, content, date_created FROM newsarticles ORDER BY date_created DESC";
        List<NewsArticle> news = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                NewsArticle article = new NewsArticle(
                        rs.getInt("news_article_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("date_created").toLocalDateTime().toLocalDate()
                );

                news.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return news;
    }
} 

