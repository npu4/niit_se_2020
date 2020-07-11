package com.niit.lesson4;

public class MethodOverloading {


    public static void main(String[] args) {
        final Person vasya = new Person("Vasya");
        final Person petya = new Person("Petya");



        vasya.sayHello();
        vasya.sayHello(petya);
        vasya.sayHello("Здравствуйте ",petya);
        vasya.sayHello(petya,"Здравствуйте ");


        System.out.println(vasya.name + petya.name);

    }
}
