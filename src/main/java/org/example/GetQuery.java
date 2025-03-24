package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetQuery {
    private final Connection conn;

    public GetQuery(Connection conn){
        this.conn = conn;
    }

    public List<Student> getAllStudents(int limit, int offset, String subject) throws SQLException {
        var query = String.format("SELECT * FROM students WHERE subject='%s' LIMIT %d OFFSET %d", subject, limit, offset);
        var stmt = conn.prepareStatement(query);
        var result = stmt.executeQuery();
        var students = new ArrayList<Student>();
        while(result.next()){
            students.add(new Student(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3)));
        }
        return students;
    }
}
