package com.java.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Filter;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindLength {
    public static void main(String[] args) {
        findLength();
    }

    public static void findLength() {
        List<String> list = Arrays.asList("Ashoka", "Rabindra", "Erika", "ritik", "Ayshu", "Latika");
        Predicate<String> p1 = (s) -> {
            //   return (s.startsWith("A") || s.startsWith("E") || s.startsWith("I") || s.startsWith("O")||s.startsWith("U"));
            boolean flag = false;

            char c = s.charAt(0);
            switch (Character.toUpperCase(c)) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    flag = true;
            }
            return flag;
        };
        Function<String, Integer> func = (s) -> {
            return s.length();
        };
        List<Integer> list1 = list.stream().filter(p1).map(func).collect(Collectors.toList());
        System.out.println(list1);
    }
}
