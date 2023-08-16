package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    public static Connection getPostgreSQLConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/demo_jdbc";
        String user = "postgres";
        String password = "Pa$$w0rd";

        Connection connection = DriverManager.getConnection(url,user,password);

        return connection;
    }
}
