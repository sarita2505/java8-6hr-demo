package com.java.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        //test();
        //and();
        //negate();
        //or();
        biPrediacte();
    }
    public static void test(){
        Predicate<Integer> m1=(i)->{
            return i<10;
        };
        System.out.println(m1.test(11));
    }
    public static void and(){
        Predicate<Integer> m1=(i)->{
            return i<10;
        };
        Predicate<Integer>m2=(i)->{
            return i>10;
        };
        Predicate predicate=m1.and(m2);
        System.out.println(predicate.test(5));
    }
    public static void negate(){
        Predicate<Integer> m3=(i)->{
            return i<10;
        };
        m3.negate();
        System.out.println(!m3.test(11));
    }
    public static void or(){
        Predicate<Integer> m3=(i)->{
            return i<10;
        };
        Predicate<Integer> m4=(i)->{
            return i>10;
        };
       Predicate  predicate= m3.or(m4);
        System.out.println(m3.test(5));
    }
    public static void biPrediacte(){
        BiPredicate<Integer,Integer> m1=(a,b)->{
            return a>b;
        };
        BiPredicate<Integer,Integer> m2=(a,b)->{
            return a<b;
        };
        BiPredicate predicate=m1.and(m2);
        System.out.println(predicate.test(10,2));
    }
}
