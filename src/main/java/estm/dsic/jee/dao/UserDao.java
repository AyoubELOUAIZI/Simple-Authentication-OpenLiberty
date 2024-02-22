package estm.dsic.jee.dao;

import estm.dsic.jee.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // User found, create User object
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
        } finally {
            // Close resources
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            DatabaseUtil.closeConnection();
        }

        return user;
    }

    public void addUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseUtil.getConnection();
            String query = "INSERT INTO users (email, username, password) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } finally {
            // Close resources
            if (statement != null) {
                statement.close();
            }
            DatabaseUtil.closeConnection();
        }
    }
}
