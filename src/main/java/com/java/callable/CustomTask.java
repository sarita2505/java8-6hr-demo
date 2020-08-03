package com.java.callable;

import java.util.concurrent.Callable;

public class CustomTask<V> implements Runnable {
    private V returnValue;
    private Callable<V> c;
    private Boolean flag;

    public CustomTask(Callable c) {
        this.c = c;
        this.flag=false;
    }

    @Override
    public void run() {
        try {
            returnValue = c.call();
            flag=true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public V get() {
        for (;;){
            System.out.println("wait");
            if (flag){
                System.out.println("returning");
              return returnValue;
            }
            //System.out.println("wait");
        }
        //System.out.println("returning");
        //return returnValue;
    }
}
