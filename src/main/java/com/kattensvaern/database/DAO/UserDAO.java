package com.kattensvaern.database.DAO;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import com.kattensvaern.database.models.UserProfile;

@Repository
public class UserDAO {

    private final DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public UserCredentials findByEmail(String email) {

        String sql = """
            SELECT u.user_id, u.user_type,
                   u.password_hash, u.enabled, ui.email
            FROM users u
            JOIN userInfo ui ON u.user_id = ui.user_id
            WHERE LOWER(ui.email) = LOWER(?)
            """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new UserCredentials(
                        rs.getInt("user_id"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        rs.getString("user_type"),
                        rs.getBoolean("enabled")
                    );
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Failed to load user", e);
        }

        return null;
    }

    public UserProfile findProfileByEmail(String email) {

        String sql = """
            SELECT
                u.user_id,
                ui.name,
                ui.email,
                ui.phonenumber,
                ui.age,
                ui.address,
                COALESCE(m.is_member, FALSE) AS is_member,
                m.membership_number
            FROM users u
            JOIN userInfo ui ON u.user_id = ui.user_id
            LEFT JOIN membership m ON u.user_id = m.user_id
            WHERE LOWER(ui.email) = LOWER(?)
            """;

        try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new UserProfile(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phonenumber"),
                        rs.getInt("age"),
                        rs.getString("address"),
                        rs.getBoolean("is_member"),
                        rs.getString("membership_number")
                    );
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Failed to load user profile", e);
        }

        return null;
    }


    public record UserCredentials(
        int id,
        String email,
        String passwordHash,
        String role,
        boolean enabled
    ) {}
}
