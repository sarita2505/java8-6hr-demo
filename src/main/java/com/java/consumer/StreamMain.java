package com.java.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        //listOfStream();
        //listUsingConsumer();
        //convertListToStream();
       consumer();
       // supplier();
       // biConsumer();

    }

    public static void listOfStream(){
        String[] strings=new String[]{"hari","ram","mita","gita","anki"};
        Stream<String> stream=Stream.of(strings);

        stream.forEach(elt->
                System.out.println(elt)); {

        }
    }
    public static void listUsingConsumer(){
        String[] strings=new String[]{"hari","ram","mita","gita","anki"};
        Stream<String> stream=Stream.of(strings);
        Consumer consumer=(s)->{
            System.out.println("name :" +s);
        };
        stream.forEach(consumer);

    }

    public static void convertListToStream() {
        List<String> list = new ArrayList<>();
        list.add("anki");
        list.add("gopal");
        list.add("chinu");
        Stream<String> stream=list.stream();
        stream.forEach(elt-> System.out.println(elt));
//        list
//                .stream()
//                .forEach(c ->
//                        System.out.println(c));

    }

    public static void consumer(){
        List<String> list=Arrays.asList("hari","ram","sita","gopal");
        Consumer<String>  consumer=(e)->{
            System.out.println("===="+e);
        };
        Consumer<String> consumer1=(e)->{
            System.out.println("----"+e);
        };
        Consumer<String> c = consumer.andThen(consumer1);
        list.stream().forEach(c);
       // c.accept("welcome");

    }
    public static void supplier(){
        Supplier<String> supplier=()->{
            return "hello";
        };
        System.out.println(supplier.get());
    }
    public static void biConsumer(){
        BiConsumer<String,String> biConsumer=(s1,s2)->{
            System.out.println(s1+" "+s2);
        };
        biConsumer.accept("hello","hii");
    }
}
