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

        String sql = "SELECT * FROM newsarticles ORDER BY date DESC";
        List<NewsArticle> news = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                NewsArticle article = new NewsArticle(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("imageurl")
                );

                news.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return news;
    }
} 

