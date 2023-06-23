package com.sj.empmanagmentapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        // Private constructor to prevent instantiation outside the class
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            // Provide the database connection details
            String url = "jdbc:mysql://localhost:3306/javaProject?user=root&password=";

            try {
                // Establish the database connection
                connection = DriverManager.getConnection(url);
                System.out.println("Connection success");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
