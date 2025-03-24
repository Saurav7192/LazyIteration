package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {

    public static void connect(){
        try{
            String url = "jdbc:mysql://localhost:3306/mysql";
            String username  = "root";
            String password = "";
            DriverManager.getConnection(url, username, password);
            System.out.println("Connected to mysql...");
        } catch (SQLException e) {
            System.out.println("Unable to connect with mysql server: "+e);
        }

    }
}
