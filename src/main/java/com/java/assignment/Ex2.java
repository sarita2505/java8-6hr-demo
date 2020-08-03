package com.java.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//flter the names which starts with vowel and return their lengths
public class Ex2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("rabi", "guru", "basant", "arun", "e", "wani");
        Predicate<String> p1 = (p) -> {
            return p.startsWith("a") || p.startsWith("e") ||
                    p.startsWith("i") || p.startsWith("o") || p.startsWith("u");
        };
        List<Integer> list1 = list.
                stream().
                filter(p1).
                map((f1) -> {
                    return f1.length();
                }).
                collect(Collectors.toList());

        System.out.println(list1);

    }
}
