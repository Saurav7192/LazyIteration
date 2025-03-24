package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {

    public static Connection connect() throws SQLException{
            String url = "jdbc:mysql://localhost:3306/mysql";
            String username  = "root";
            String password = "";
            return DriverManager.getConnection(url, username, password);
    }
}
