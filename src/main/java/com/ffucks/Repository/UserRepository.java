package com.ffucks.Repository;

import com.ffucks.Models.User;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserRepository {

    private final DataSource ds;

    public UserRepository(DataSource ds) {
        this.ds = ds;
    }

    public User findUser(int id) throws SQLException {
        try (var conn = ds.getConnection();
             var stmt = conn.prepareStatement("SELECT id, name FROM users WHERE id = ?")) {

            stmt.setInt(1, id);
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                }
                return null;
            }
        }
    }

    public void saveUser(User user) throws SQLException {
        try (var conn = ds.getConnection();
             var stmt = conn.prepareStatement("INSERT INTO users(id, name) VALUES (?, ?)")) {

            stmt.setInt(1, user.id());
            stmt.setString(2, user.name());
            stmt.executeUpdate();
        }
    }
}
