package Dao;

import java.sql.*;

public class MyDBTools{
    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "admin";
    private static final String DB_PASS = "bnmmnb";
    private static final String DB_PAR_ENC = "characterEncoding=utf8";
    private static final String DB_PAR_SSL = "useSSL=false";


    /*public static int insert(Connection conn, String query, String... params) throws SQLException{
        return stmt(conn, query, params).executeUpdate();
    }

    public static PreparedStatement stmt(Connection cnt, String query, String... params) throws SQLException  {
        PreparedStatement statement = cnt.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            statement.setString(i + 1, params[i]);
        }
        System.out.println(statement.toString());
        return statement;
    }*/

    public static Connection mySQLConnect(String database) throws SQLException {
        String DB_PARAMS = "?" + DB_PAR_ENC + "&" + DB_PAR_SSL;
        String url = DB_URL + (database != null ? "/" + database : "") + DB_PARAMS;
        return DriverManager.getConnection(url, DB_USER, DB_PASS);
    }

    public static void printData(Connection c, String q, String... columnNames) throws SQLException {
        for (String param : columnNames) {
            System.out.printf("| %s ", param);
        }
        System.out.println("|");
        try (
                PreparedStatement statement = c.prepareStatement(q);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                for (String param : columnNames) {
                    System.out.printf("| %s ", resultSet.getString(param));
                }
                System.out.println("|");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
