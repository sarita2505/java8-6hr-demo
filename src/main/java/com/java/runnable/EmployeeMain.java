package com.java.runnable;

import com.java.runnableEx.EmployeeRunnable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        //  Employee employee= Employee::new;
        //runnableBy7();
        //runnableBy8();
        comparotorBy8();

    }

    public static void runnableBy7() {
        Runnable runnable = new EmployeeRunnable();
        Thread thread = new Thread(runnable, "t1");
        thread.start();
    }

    public static void runnableBy8() {
        Runnable runnable=()->{
            System.out.println("inside run() in 8:"+Thread.currentThread().getName());
        };
        Thread thread=new Thread(runnable,"t1");
        thread.start();
    }
    public static void comparotorBy8(){
        List<String> list= Arrays.asList("hari","nilu","anki","milu");
        Comparator<String>comparator=(s1,s2)->{
            return s1.compareTo(s2);
        };
        Collections.sort(list,comparator);
        System.out.println(list);
    }
}
