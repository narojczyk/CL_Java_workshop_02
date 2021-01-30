
import java.sql.*;

public class MyDBTools{
    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "admin";
    private static final String DB_PASS = "bnmmnb";
    private static final String DB_PARAMS = "?characterEncoding=utf8";
    private static final String DELETE_QUERY = "DELETE FROM tableName where id = ?";


    public static Connection mySQLConnect(String database) throws SQLException {
        String url = DB_URL + (database != null ? "/" + database : "") + DB_PARAMS;

        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

    }

}
