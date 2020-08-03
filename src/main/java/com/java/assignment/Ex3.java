package com.java.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

// Employee {name,city} = list , convert to hashmap<name,city>
public class Ex3 {
    public static void main(String[] args) {
        Employee e1 = new Employee("a", "aa");
        Employee e2 = new Employee("b", "bb");
        Employee e3 = new Employee("c", "cc");
        Employee e4 = new Employee("c", "cd");
        List<Employee> list1 = Arrays.asList(e1, e2, e3, e4);
        

        Map<String,String> map=list1.stream().
                collect(Collectors.toMap((Employee::getName),(Employee::getCity),(key1,key2)->{
                    return key2;
                }));
        System.out.println(map);
    }
}


class Employee {
    private String name;
    private String city;

    public Employee() {
    }

    public Employee(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
