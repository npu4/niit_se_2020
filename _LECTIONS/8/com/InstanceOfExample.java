package com;

public class InstanceOfExample {


    public static void main(String[] args) {
        Object o = null;

        PersonRefl p = (PersonRefl) o;


        if (p instanceof PersonRefl) {
            System.out.println("Это - человек");
        }

        System.out.println("Person is assignable from Object");
        System.out.println(Object.class.isAssignableFrom(PersonRefl.class));

    }
}
