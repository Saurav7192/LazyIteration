package org.example;

import java.sql.SQLException;

public interface CustomIterable<T> extends Iterable<T>{
    Page<Student> next() throws SQLException;
    boolean hasNext();
}
