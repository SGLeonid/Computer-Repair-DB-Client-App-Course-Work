import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class SQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/courseschema";
    private static final String USER = "root";
    private static final String PASSWORD = "Gl30127602";

    public static Connection getConnection() throws SQLException
    {
        try
        {
             return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e)
        {
            System.out.println("Cannot connect to MySQL Database");
            return null;
        }
    }
}
