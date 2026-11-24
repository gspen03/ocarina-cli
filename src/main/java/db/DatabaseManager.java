package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager
{
    private static final String URL = System.getenv().get("DB_URL");
    private static final String USER = System.getenv().get("DB_USER");
    private static final String PASSWORD = System.getenv().get("DB_PASS");

    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}