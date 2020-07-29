package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {
        // filter();
        //map();
        //anyMatchAndAllmatch();
        findFirstAndFindAny();
    }

    public static void filter() {
        List<Integer> list = Arrays.asList(12, 3, 4);
        Predicate<Integer> p1 = (p) -> {
            return (p % 2 == 0);
        };
        List<Integer> evenList = list.stream().filter(p1).collect(Collectors.toList());
        System.out.println(evenList);
    }

    public static void map() {
        List<String> list = Arrays.asList("hari", "giri", "sita");
        Function<String, Integer> function = (s) -> {
            return s.length();
        };
        List<Integer> list1 = list.stream().map(function).collect(Collectors.toList());
        System.out.println(list1);
    }

    public static void anyMatchAndAllmatch() {
        List<Integer> list = Arrays.asList(1, 0, 1, 0);
        Predicate<Integer> p1 = (i) -> {
            return i == 0;
        };
        boolean flag = list.stream().anyMatch(p1);
        System.out.println(flag);
        boolean flag1 = list.stream().allMatch(p1);
        System.out.println(flag1);
    }

    public static void findFirstAndFindAny() {
        List<Integer> list = Arrays.asList(5,4,10, 1, 2,30,50,3,55, 66 , 7);
       Optional <Integer> flag = list.stream().findFirst();
        System.out.println(flag.get());
        Optional <Integer> flag1 = list.stream().findAny();
        System.out.println(flag1.get());
    }
}
