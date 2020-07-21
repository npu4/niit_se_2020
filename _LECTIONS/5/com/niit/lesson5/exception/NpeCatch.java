package com.niit.lesson5.exception;

public class NpeCatch {

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        Person p = new Person("Вася");
        try {
            printNameLength(p);
        } catch (NullPointerException | ArithmeticException e) {
            System.out.println("0");
        }
        System.out.println("Длина имени выведена успешно");
    }


    public static void printNameLength(Person person) {
        int a = 42;
        System.out.println(a / 0);
        System.out.println(person.name.length());

    }
}
