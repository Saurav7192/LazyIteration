package org.example;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Page<T> {
    private List<T> list;
    private int offset;
}
