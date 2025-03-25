package org.example;

import lombok.Builder;

import java.util.List;

@Builder
public class Page<T> {
    List<T> list;
    int offset;
}
