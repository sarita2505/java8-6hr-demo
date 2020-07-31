package com.java.pratice.methodref;

import com.java.runnableEx.EmployeeRunnable;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class MethodRefEx {
    public static void main(String[] args) {
        byLambda();
        byMethodref();
    }

    public static void byLambda() {
        Runnable runnable = () -> {
            System.out.println("inside the run(): " + Thread.currentThread().getName());
        };
        Thread thread = new Thread(runnable, "t1");
        thread.start();
    }

    public static void byMethodref()
    {
        Runnable runnable = MethodRefEx::task;
        Thread t = new Thread(runnable);
        t.start();

        EmployeeRunnable er = new EmployeeRunnable();
        runnable = er::run;
        t = new Thread(runnable);
        t.start();
    }

    public static void task()
    {
        System.out.println(" this is run method ");
    }

    private void showFunctionAsMethodref()
    {
        List<String> names = Arrays.asList("anis","asisa","lisarani");
        List<Integer> nameLength = names.
                stream().
                map(e->
                {
                    return e.length();
                }
                ).
                collect(Collectors.toList());
        nameLength = names.stream().map(MethodRefEx::getLength).collect(Collectors.toList());
    }

    public static int getLength(String s)
    {
        return s.length();
    }
    public void methodRefExample() {

        Consumer<Integer> consumer = MethodRefEx::display;
        MethodRefEx ex = new MethodRefEx();
        consumer = ex::show;

        UnaryOperator<Integer> unaryOperator = ex::function1;
        unaryOperator = MethodRefEx::function2;

        Predicate<Integer> integerPredicate = ex::validate;
        Supplier<Integer> integerSupplier = ex::getData;

        BiFunction<Integer,String,String> biFunction = ex::getBiStr;
    }

    private String getBiStr(int x, String y)
    {
        return null;
    }
    private int getData()
    {
        return 0;
    }
    private boolean validate(int x)
    {
        return true;
    }
    private int function1(int x)
    {
        return 0;
    }


    private static int function2(int x)
    {
        return 0;
    }

    private void show(int x)
    {
        System.out.println(x);
    }

    private static void display(int x)
    {
        System.out.println(x);
    }
}
