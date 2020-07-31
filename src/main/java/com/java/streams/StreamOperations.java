package com.java.streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        // filter();
        //map();
        //anyMatchAndAllmatch();
        // findFirstAndFindAny();
        // limit();
        //distinct();
        // count();
        //generator();
        //iterate();
        //reduce();
        //peek();
        //concat();
        toArry();
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
        List<Integer> list = Arrays.asList(5, 4, 10, 1, 2, 30, 50, 3, 55, 66, 7);
        Optional<Integer> flag = list.stream().findFirst();
        System.out.println(flag.get());
        Optional<Integer> flag1 = list.stream().findAny();
        System.out.println(flag1.get());
    }

    public static void limit() {
        List<Long> list = Arrays.asList(1l, 2l, 3l, 4l, 5l, 67l, 77l);
        list = list.stream().limit(4).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void distinct() {
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 23, 3, 4, 4);
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);

    }

    public static void count() {
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 23, 3, 4, 4);
        Long c = list.stream().count();
        System.out.println(c);
    }

    public static void generator() {
        Stream<Integer> stream = Stream.generate(() -> {
            return new Random().nextInt();
        }).limit(10);

        stream.forEach((e) -> {
            System.out.println(e);
        });

    }

    public static void iterate() {
        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(x -> System.out.println(x));
        List<String> list = Arrays.asList("ram", "ramya", "rabi");
        UnaryOperator<String> s = (e) -> {
            return e + "-" + e.length();
        };
        list = Stream.iterate("welcome", s).limit(3).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void reduce() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

// 1st argument, init value = 0
        //int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
        Optional<Integer> sum = Arrays.stream(numbers).reduce((a, b) -> a + b);

        System.out.println("sum : " + sum.get()); // 55
    }

    public static void peek() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> c1 = (e) -> {
            System.out.println(e);
        };
        list = list.stream().peek(c1).collect(Collectors.toList());
        //System.out.println(list);
    }

    public static void concat() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> s1 = list.stream();
        Stream<Integer> s2 = Stream.of(11, 12, 13, 14, 15);
        Stream<Integer> s3 = Stream.concat(s1, s2);
        List<Integer> l2 = s3.collect(Collectors.toList());
        System.out.println(l2);
    }

    public static void toArry() {
        Stream<Integer> s2 = Stream.of(11, 12, 13, 14, 15);
        Object[] a1 = s2.toArray();
        System.out.println(Arrays.toString(a1));

        Stream<Integer> s3 = Stream.of(11, 12, 13, 14, 15);
        s3 = Stream.empty();
        System.out.println(s3.collect(Collectors.toList()));
    }
    public static void takeWhile(){
//        Stream<Integer> stream
//                = Stream.of(4, 4, 4, 5, 6, 7, 8, 9, 10);
//
//        // apply takeWhile to take all the numbers
//        // matches passed predicate
//        List<Integer> list
//                = stream.takeWhile(number -> (number / 4 == 1))
//                .collect(Collectors.toList());
//
//        // print list
//        System.out.println(list);
    }
}
