package com.java.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) throws Exception {
        //m1();
        //m2();
        //   callableWithSingleExecutor();
        //     isDoneWithSingleExecutor();
        //  futureWithCancel();
        //timeOut();
        //invokeAll();
        invokeAny();
    }

    //future task by java
    private static void m1() throws Exception {
        Callable callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        Thread t1 = new Thread(futureTask);
        t1.start();
        System.out.println(futureTask.get());
    }

    //custom future task
    private static void m2() {
        Callable callable = new MyCallable();
        CustomTask task = new CustomTask(callable);
        Thread t1 = new Thread(task);
        t1.start();
        System.out.println(task.get());
        System.out.println(task.get());
    }

    private static void callableWithSingleExecutor() throws Exception {
        Callable callable = new MyCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);
        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        // Future.get() blocks until the result is available
        String result = future.get();
        System.out.println(result);

        executorService.shutdown();

    }

    public static void isDoneWithSingleExecutor() {

        Callable callable = new MyCallable();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        while (!future.isDone()) {
            System.out.println("Task is still not done...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Task completed! Retrieving the result");
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        executorService.shutdown();
    }

    private static void futureWithCancel() {
        Callable callable = new MyCallable();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        while (!future.isDone()) {
            System.out.println("Task is still not done...");
            try {
                Thread.sleep(700);
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        future.cancel(true);

        System.out.println("Task completed! Retrieving the result");
        String result = null;
        // retrieve with checking cancel.
        if (!future.isCancelled()) {
            try {
                result = future.get();
                System.out.println("with cancel: " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("task has been cancelled");
        }

        // retrieve without checking fotr cancell
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);


        executorService.shutdown();
    }

    public static void timeOut() {
        Callable callable = new MyCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);
        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        // Future.get() blocks until the result is available
        String result = null;
        try {
            result = future.get(1, TimeUnit.SECONDS);
            System.out.println("time out");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        executorService.shutdown();
    }
    private static void invokeAll(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(5000);
            return "Result of Task3";
        };

        List<Callable<String>> taskList = Arrays.asList(task1, task2, task3);

        List<Future<String>> futures = null;
        try {
            futures = executorService.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Future<String> future: futures) {
            // The result is printed only after all the futures are complete. (i.e. after 5 seconds)
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
    private static void invokeAny(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(5000);
            return "Result of Task3";
        };

        List<Callable<String>> taskList = Arrays.asList(task1, task2, task3);

        //List<Future<String>> futures = null;
        String future=null;
        try {
             future=executorService.invokeAny(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // The result is printed only after all the futures are complete. (i.e. after 5 seconds)
        System.out.println(future);


        executorService.shutdown();
    }
}
