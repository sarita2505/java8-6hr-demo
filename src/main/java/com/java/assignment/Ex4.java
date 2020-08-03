package com.java.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Empoyees from 3 different cities u need to disp.city name,list of employee
public class Ex4 {
    public static void main(String[] args) {
        Employee e1 = new Employee("a", "aa");
        Employee e5 = new Employee("a1", "aa");
        Employee e2 = new Employee("b", "bb");
        Employee e6 = new Employee("b1", "bb");
        Employee e3 = new Employee("c", "cc");
        Employee e4 = new Employee("c", "cd");
        List<Employee> list1 = Arrays.asList(e1, e2, e3, e4, e5, e6);
       Map<String,List<Employee>>map= list1.stream().
                collect(Collectors.groupingBy((elt)->{return elt.getCity();}));
        System.out.println(map);
    }
}
