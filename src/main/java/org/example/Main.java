package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello, World!");
        Connection conn = null;
        try{
            conn = MySqlConnector.connect();
            System.out.println("My Sql is connected...");
        } catch (SQLException e) {
            System.out.println("Db connection failed: "+e);
        }
        System.out.println(new GetQuery(conn).getAllStudents(10, 0, "English"));

    }
}