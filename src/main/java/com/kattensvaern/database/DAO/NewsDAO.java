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

        String sql = "SELECT news_article_id, title, content, date_created, published_by FROM newsarticles ORDER BY date_created DESC";
        List<NewsArticle> news = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                NewsArticle article = new NewsArticle(
                        rs.getInt("news_article_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("date_created").toLocalDateTime().toLocalDate(),
                        rs.getString("published_by")
                );

                news.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return news;
    }






    // FIND NEWS BY ID
    public NewsArticle findNewsById(int id) {
        String sql = "SELECT news_article_id, title, content, date_created, published_by FROM newsarticles WHERE news_article_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new NewsArticle(
                            rs.getInt("news_article_id"),
                            rs.getString("title"),
                            rs.getString("content"),
                            rs.getTimestamp("date_created").toLocalDateTime().toLocalDate(),
                            rs.getString("published_by")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void CreateNews(NewsArticle article) {
        String sql = "INSERT INTO newsarticles (title, content, published_by) VALUES (?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, article.getTitle());
            stmt.setString(2, article.getContent());
            stmt.setString(3, article.getPublishedBy());


            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SOMETHINGS WRONG AAAAAAAAAAAH");
            throw new RuntimeException(e);
        }
    }

    // DELETE NEWS
    public void DeleteNews(int id) {
        String sql = "DELETE FROM newsarticles WHERE news_article_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SOMETHINGS WRONG AAAAAAAAAAAH");
            throw new RuntimeException(e);
        }
    }

    // UPDATE NEWS
    public void UpdateNews(NewsArticle article) {
        String sql = "UPDATE newsarticles SET title = ?, content = ?, published_by = ? WHERE news_article_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, article.getTitle());
            stmt.setString(2, article.getContent());
            stmt.setString(3, article.getPublishedBy());
            stmt.setInt(4, article.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SOMETHINGS WRONG AAAAAAAAAAAH");
            throw new RuntimeException(e);
        }
    }



} 

