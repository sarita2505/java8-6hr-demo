package com.java.custom.functional;

@FunctionalInterface
public interface Validator {
    boolean validate(int x, int y, int z);
}
