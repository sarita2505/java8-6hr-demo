package com.java.sorting;

import com.java.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeMain {
    public static void main(String[] args) {
        //sortBySalary();
        //maxMin();
        flatMap();
    }

    public static void sortBySalary() {
        Employee employee1 = new Employee("a", 1, 10000.0, "se1");
        Employee employee2 = new Employee("b", 3, 20000.0, "se1");
        Employee employee3 = new Employee("af", 2, 10000.0, "se2");
        Employee employee4 = new Employee("c", 6, 10000.0, "se2");
        Employee employee5 = new Employee("f", 5, 30000.0, "se3");
        Employee employee6 = new Employee("g", 7, 30000.0, "se3");
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6);
        List<Employee> sort = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(sort);

        Comparator<Employee> c1 = Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName);
        List<Employee> sortBySalThenName = employees.stream().sorted(c1).collect(Collectors.toList());
        System.out.println(sortBySalThenName);
    }

    public static void maxMin() {
        Employee employee1 = new Employee("a", 1, 10000.0, "se1");
        Employee employee2 = new Employee("b", 3, 20000.0, "se1");
        Employee employee3 = new Employee("af", 2, 10000.0, "se2");
        Employee employee4 = new Employee("c", 6, 10000.0, "se2");
        Employee employee5 = new Employee("f", 5, 30000.0, "se3");
        Employee employee6 = new Employee("g", 7, 30000.0, "se3");
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6);
        Employee employee = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(employee);

        Employee emp = employees.stream().min(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(emp);
    }

    public static void flatMap() {
        List<String> list1 = Arrays.asList("aman", "adri", "adya", "anup");
        List<String> list2 = Arrays.asList("bishnu", "barun", "bidur");
        List<String> list3 = Arrays.asList("chinu", "chintu");
        List<List<String>> lists = Arrays.asList(list1, list2, list3);
        System.out.println(lists);
        Function<List<String>, Stream<String>> func = (list)->{
            return list.stream();
        };
        List<String> list = lists.stream().flatMap(func).collect(Collectors.toList());
        System.out.println(list);
    }
}
