package com.java.assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//given ist of integers find the highest value
public class Ex6 {
    public static void main(String[] args) {
        byJava7();
        byJava8();
        byJava88();
    }

    public static void byJava7() {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 8, 7, 9);
        l1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(l1);
        Integer h1 = l1.get(l1.size() - 1);
        System.out.println(h1);
    }

    public static void byJava8() {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 8, 7, 9);
        Comparator<Integer> c1 = (c2, c3) -> {
            return c2.compareTo(c3);
        };
        l1.sort(c1);
        Integer h1 = l1.get(l1.size() - 1);
        System.out.println(h1);
    }

    public static void byJava88()
    {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 8, 7, 9);
       int result = l1.stream().min(Integer::compareTo).get();
        System.out.println(result);
    }
}

