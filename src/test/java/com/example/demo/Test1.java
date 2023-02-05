package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Test1 {

    List<String> programmingLanguage = List.of("Node", "Java", "C++", "Go", "Ruby", "R");

    @Test
    void testSort() {
        programmingLanguage.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void distinct() {
        programmingLanguage.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
