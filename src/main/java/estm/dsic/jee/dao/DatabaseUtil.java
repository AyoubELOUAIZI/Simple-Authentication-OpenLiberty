package estm.dsic.jee.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testAuthDatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private static Connection connection;

    private DatabaseUtil() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Create a new connection if it doesn't exist or is closed
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("\nNew connection to database established: " + connection);
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection to database closed.");
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}

