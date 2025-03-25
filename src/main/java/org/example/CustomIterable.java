package org.example;

import java.sql.SQLException;

public interface CustomIterable<T> extends Iterable<T>{
    Page<Student> hasNext() throws SQLException;
}
