package com.company;

public class Parsing {

    public static void main(String[] args) {
        String firstVar = "2";
        String second = "42";

        final Integer parsedFirst = Integer.parseInt(firstVar);
        final Integer parsedSecond = Integer.parseInt(second);

        final Integer x = parsedFirst / parsedSecond;
        System.out.println(x);


        final Integer copiedSecond = parsedSecond;
        int primitiveVariable = 42;
        System.out.println(parsedFirst);
        System.out.println(parsedSecond);
        System.out.println(copiedSecond);

        System.out.println( (primitiveVariable + 2) / 2);

    }
}
