package com.niit.lesson5;

public class Dog extends Animal {

    @Override
    public void saySomething() {
        System.out.println("гав-гав!");;
    }



    public void sayHello() {
        System.out.println("Привет, я собака");
    }
}
