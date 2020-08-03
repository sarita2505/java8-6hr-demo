package com.java.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread());
        System.out.println(System.currentTimeMillis());
        Thread.sleep(2000);
        System.out.println("sleeping time completed");
        System.out.println(System.currentTimeMillis());
        System.out.println(Thread.currentThread());
        return "hello";
    }
}
