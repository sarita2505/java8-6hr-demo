package com.java.assignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SalaryRevers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 3, 4);
        // Collections.reverse(list);
        //System.out.println(list);
//        Comparator<Integer> comparator=(c1,c2)->{
//            return c1.compareTo(c2);
//        };

//       comparator=comparator.reversed();
        //comparator only sorts the elements does not revers the elemets.
        Comparator<Integer> comparator1 = Comparator.reverseOrder();
        System.out.println(list);
        list = list.stream().sorted(comparator1).collect(Collectors.toList());
        System.out.println(list);
    }
}
