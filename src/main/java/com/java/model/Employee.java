package com.java.model;

public class Employee {
    private String name;
    private int id;
    private Double salary;
    private String desgination;

    public Employee() {
    }

    public Employee(String name, int id, Double salary, String desgination) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.desgination = desgination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDesgination() {
        return desgination;
    }

    public void setDesgination(String desgination) {
        this.desgination = desgination;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", desgination='" + desgination + '\'' +
                '}';
    }
}
