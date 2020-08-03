package com.java.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//take list of names return the len. of every stream
public class Ex1 {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("akash","gugu","adya");
        Function<String,Integer> f1=(c1)->{return c1.length();};
        Function<String,String> f2=(c1)->{return c1+" - "+c1.length();};
       List<Integer> list1= list.stream().map(f1).collect(Collectors.toList());
       List<String> list2= list.stream().map(f2).collect(Collectors.toList());
        System.out.println(list1);
        System.out.println(list2);
    }
}
