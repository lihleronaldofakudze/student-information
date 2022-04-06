import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private final String URL = "localhost:3306/";
    private final String USERNAME = "root";
    private final String DATABASE = "student_information";
    private final String PASSWORD = "";

    private Connection connection;

    public Connector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}