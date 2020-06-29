package com.company;

public class EqualsComparision {

    public static void main(String[] args) {


        Integer a = 100_500;
        Integer b = 100_500;


        final Boolean equals = a.equals(b);
        System.out.println(equals);


        System.out.println(a == b);



        Integer one = 42;
        Integer second = 42;

        System.out.println(one == second);
    }
}
