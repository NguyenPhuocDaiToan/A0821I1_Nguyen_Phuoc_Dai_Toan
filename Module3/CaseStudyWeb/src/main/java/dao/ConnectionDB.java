package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    static final String URL = "jdbc:mysql://localhost:3306/case_study_web";
    static final String USER = "root";
    static final String PASS = "daitoan2002";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        return connection;
    }
}
