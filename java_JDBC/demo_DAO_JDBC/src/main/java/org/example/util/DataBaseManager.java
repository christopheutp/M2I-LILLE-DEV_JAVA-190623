package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private static final String URI = "jdbc:postgresql://localhost:5432/demo_jdbc";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Pa$$w0rd";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}
