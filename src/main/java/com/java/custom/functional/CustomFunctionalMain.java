package com.java.custom.functional;

public class CustomFunctionalMain {
    public static void main(String[] args) {
        Validator validator = CustomFunctionalMain::check;
        System.out.println(validator.validate(10, 20, 30));
        System.out.println(validator.validate(10, 20, 31));

        validator = (x,y,z)->{
            int sum = x + y + z;
            return sum % 2 == 0;
        };
        System.out.println(validator.validate(10, 20, 30));
        System.out.println(validator.validate(10, 20, 31));



    }

    private static boolean check(int x, int y, int z) {
        int sum = x + y + z;
        return sum % 2 == 0;
    }
}
