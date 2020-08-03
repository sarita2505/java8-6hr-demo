package com.java.assignment;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//given a list of maps where each map points to the temp of a given day.
// u have to find the highest temp.of each day
public class Ex7 {
    private static final List<Map<String, Float>> list = new ArrayList<>();

    public static void main(String[] args) {
        Map<String, Float> map = new HashMap<>();
        map.put("c1", 21.0F);//day1
        map.put("c2", 22.0F);
        map.put("c3", 24.0F);
        map.put("c4", 23.0F);
        Map<String, Float> map1 = new HashMap<>();
        map1.put("c1", 24.0F);//day2
        map1.put("c2", 22.0F);
        map1.put("c3", 25.0F);
        Map<String, Float> map3 = new HashMap<>();
        map3.put("c1", 26.0F);//day3
        map3.put("c2", 23.0F);
        map3.put("c3", 24.0F);
        list.add(map);
        list.add(map1);
        list.add(map3);

        m1();
        m2();
        m3();
    }

    private static  Comparator<Map.Entry<String, Float>>  getComp()
    {

        Comparator<Map.Entry<String, Float>> cc = (c1, c2) -> {
            return c1.getValue().compareTo(c2.getValue());
        };
        return cc;
    }
    // using collectors max by
    private static void m3()
    {
        Function<Map<String,Float>,Map.Entry<String,Float>> ff=(m)->{
            return m.entrySet().stream().
                    collect(Collectors.maxBy(getComp())).get();
        };
        List<Map.Entry<String, Float>> entries2 = list.
                stream().
                map(ff).
                collect(Collectors.toList());
        System.out.println(entries2);
    }

    // highest cities having only one highest temp per day
    private static void m2()
    {
        Function<Map<String, Float>, Map.Entry<String, Float>> f1 = (m) -> {
            return m.
                    entrySet().
                    stream().
                    max(getComp()).
                    get();
        };

        List<Map.Entry<String, Float>> entries = list.
                stream().
                map(f1).
                collect(Collectors.toList());
        System.out.println(entries);

    }
    // print top 3 temperature of last 3 days ( 3 maps ).
    private static void m1()
    {

        Function<Map<String, Float>, List<Map.Entry<String, Float>>> f2 = (m) -> {
            return m.
                    entrySet().
                    stream().
                    sorted(getComp()).
                    limit(3).
                    collect(Collectors.toList());
        };

        List<List<Map.Entry<String, Float>>> entries1 = list.
                stream().
                map(f2).
                collect(Collectors.toList());
        System.out.println(entries1);

    }
}
