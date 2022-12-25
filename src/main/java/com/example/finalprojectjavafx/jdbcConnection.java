package com.example.finalprojectjavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnection {
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DB_NAME = "javafx";
    private static final String USERNAME = "projectuser";
    private static final String PASSWORD = "projectpass";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME), USERNAME, PASSWORD);
        } catch(SQLException se) {
            System.out.println("Cannot connect to database!");
        }
        return connection;
    }
}
