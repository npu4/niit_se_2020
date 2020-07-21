package com.niit.lesson5.exception;

public class FinallyOverride {

    public static void main(String[] args) {
        System.out.println(getNumber());
    }


    public static int getNumber() {
        try {
            return 42;
        } finally {
            throw new IllegalArgumentException("Что-то не так");
        }
    }
}
