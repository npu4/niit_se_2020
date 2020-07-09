package com.niit.lesson4;

public class Person {


    String name;

    public Person(String name) {
        this.name = name;
    }



    public void sayHello() {
        System.out.println("Привет, всем!");
    }

    public void sayHello(Person greeter) {
        System.out.println("Привет, " + greeter.name);
    }

    public void sayHello(String introduction, Person greeter) {
        System.out.println(introduction + ", " + greeter.name);
    }

    public void sayHello(Person greeter, String introduction ) {
        System.out.println("Это другой метод");
    }
}
