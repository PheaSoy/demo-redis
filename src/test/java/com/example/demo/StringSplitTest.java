package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class StringSplitTest {

    private final String fruit = "Apple,Orange,Banana";

    private List<String> fruits = List.of("Apple", "Orange", "Banana");

    @Test
    void testJavaStreamSplits() {
        var list = Arrays.stream(fruit.split(",")).toList();
        assertThat(list).isEqualTo(fruits);
    }

    @Test
    void testJava9Splits() {
        var list = List.of(fruit.split(","));
        assertThat(list).isEqualTo(fruits);
    }
}
