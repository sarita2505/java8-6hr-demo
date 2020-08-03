package com.java.assignment;

import java.util.*;

//there is a map key is String type values is float type.
// It contains city name and its temp.u have to find the city name which hve highest tem.
public class Ex5 {
    public static void main(String[] args) {
        Map<String,Float> map=new HashMap<>();
        map.put("c1",21.0F);
        map.put("c2",22.0F);
        map.put("c3",24.0F);
        map.put("c4",24.0F);
        Comparator<Map.Entry<String,Float>> c1=(f1,f2)->{return f1.getValue().compareTo(f2.getValue());};
        Map.Entry<String,Float> e=map.entrySet().stream().max(c1).get();
        System.out.println(e);
    }
}
