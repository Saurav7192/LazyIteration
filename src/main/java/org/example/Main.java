package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello, World!");

        var conn = MySqlConnector.connect();
        System.out.println("My Sql is connected...");

        var getQuery = new GetQuery(conn);

        CustomIterable<Page<Student>> pageResponse = MySqlResponse.<Page<Student>>builder()
                .getQuery(getQuery)
                .columnCondition("English")
                .limit(10)
                .build();
       List<Student> list;
        do{
            list = pageResponse.hasNext().list;
            System.out.println(list);
        } while(!list.isEmpty());
    }
}