package com.java.partitionby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartitionBy {
    public static void main(String[] args) {

        partitionBy();
    }

    public static void partitionBy() {
        List<Integer> list = Arrays.asList(2, 4, 6, 8, 3, 7, 11);
        Predicate<Integer> p1 = (i) -> {
            return (i % 2 == 0);
        };
        Map<Boolean, List<Integer>> istMap = list.stream().collect(Collectors.partitioningBy(p1));
        System.out.println(istMap);
    }
}
