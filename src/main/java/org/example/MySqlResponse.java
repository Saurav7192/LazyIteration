package org.example;

import lombok.Builder;

import java.sql.SQLException;
import java.util.Iterator;

@Builder
public class MySqlResponse<T> implements CustomIterable<T>{
    private int offset;
    private int limit;
    private String columnCondition;
    private final GetQuery getQuery;

    public Page<Student> hasNext() throws SQLException {

        var query = String.format("SELECT * FROM students WHERE subject='%s' LIMIT %d OFFSET %d", columnCondition, limit, offset);
        var students = getQuery.getAllStudents(query);
        offset += limit;
        return Page.<Student>builder()
                .list(students)
                .offset(offset)
                .build();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
