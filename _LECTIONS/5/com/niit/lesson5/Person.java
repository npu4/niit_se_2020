package com.niit.lesson5;

public class Person {
    private String name;
    private int age;


    public Person() {
    }

    public String getName() {
        if (name == null) {
            return "Имя не определено";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.getName());

    }
}
