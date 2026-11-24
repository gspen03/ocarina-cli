package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager implements AutoCloseable
{
    private static final String URL = System.getenv().get("DB_URL");
    private static final String USER = System.getenv().get("DB_USER");
    private static final String PASSWORD = System.getenv().get("DB_PASS");

    private final Connection connection;

    public DatabaseManager() throws SQLException
    {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public String getSong(String sequence)
    {
        String sql = "SELECT title FROM songs WHERE notes = ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1, sequence);

            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    return rs.getString("title");
                }
            }
        }
        catch(SQLException e)
        {
            System.err.println("Query error: " + e.getMessage());
        }
        return null;
    }

    public void printSongs()
    {
        String sql = "SELECT notes, title FROM songs ORDER BY title";

        try (PreparedStatement stmt = connection.prepareStatement(sql))
        {
            try (ResultSet rs = stmt.executeQuery())
            {
                while (rs.next())
                {
                    System.out.println(rs.getString("title") + ": " + rs.getString("notes"));
                }
            }
        }
        catch(SQLException e)
        {
            System.err.println("Query error: " + e.getMessage());
        }
    }

    @Override
    public void close() throws SQLException
    {
        if(connection != null && !connection.isClosed())
            connection.close();
    }
}