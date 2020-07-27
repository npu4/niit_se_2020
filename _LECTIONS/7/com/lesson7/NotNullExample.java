package com.lesson7;

public class NotNullExample {


    static <T>  T findFirstNonNullElement(T ... objects) {
        for (T object : objects) {
            if (object != null) {
                return object;
            }
        }

        return null;
    }


    public static void main(String[] args) {



        printStringLength( findFirstNonNullElement(null, "42", "String"));
        System.out.println(findFirstNonNullElement("ABC",null ));
        System.out.println(findFirstNonNullElement(42,null ));


    }


    public static void printStringLength(String str) {
        System.out.println(str.length());
    }

}
