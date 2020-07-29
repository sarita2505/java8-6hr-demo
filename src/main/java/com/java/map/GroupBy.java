package com.java.map;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBy {
    public static void main(String[] args) {
       // formAmapFromList();
        groupingBy();
    }
    public static void formAmapFromList(){
        List<String> list= Arrays.asList("aman","akshu","anup","alaka","sarita");
       Map<String,Integer> map= list.stream().collect(Collectors.toMap(Function.identity(),(e)->{
            return e.length();
        }));
        System.out.println(map);
    }

    public static void groupingBy(){
        List<Integer> list=Arrays.asList(3,9,27,2,8,16,5,1,25);
        Function<Integer,Integer> func=(i)->{
            if (i%3==0){
                return 3;
            }
            else if (i%2==0){
                return 2;
            }
            else if (i%5==0){
                return 5;}
            else
                return 1;
        };
        Map<Integer,List<Integer>> listMap=list.stream().collect(Collectors.groupingBy(func,Collectors.toList()));
        System.out.println(listMap);

    }
}
