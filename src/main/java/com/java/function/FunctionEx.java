package com.java.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionEx {
    public static void main(String[] args) {
        // apply();
        //compose();
        //biFunction();
        biFunctionAdThen();
    }

    public static void apply() {
        Function<String, Integer> function = (s) -> {
            return s.length();
        };
        System.out.println(function.apply("hello function"));
    }

    public static void compose() {
        Function<String, Integer> function = (s) -> {
            return s.length();
        };

        Function<Integer, Boolean> function1 = (n) -> {
            return n % 2 == 0;
        };
        Function func = function.andThen(function1);
        System.out.println(func.apply("hii"));

        Function func2=function1.compose(function);
        System.out.println(func2.apply("hii"));
    }
    public static void biFunction(){
        BiFunction<String,String,String> biFunction=(s1,s2)->{
            return s1+s2;
        };
        System.out.println(biFunction.apply("hii","hello"));
    }
    public static void biFunctionAdThen(){
        BiFunction<String,String,String> biFunction3=(s1,s2)->{
            return s1+s2;
        };
//        BiFunction<String,String,Boolean> biFunction4=(s1,s2)->{
//            return s1+s2!=null;
//        };

        Function<String,Boolean> func=(s)->{
            return s!=null;
        };
       BiFunction function= biFunction3.andThen(func);
        System.out.println(function.apply("hii","hello"));
    }
}

