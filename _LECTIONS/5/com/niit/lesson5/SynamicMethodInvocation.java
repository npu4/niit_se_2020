package com.niit.lesson5;

import java.util.Random;

public class SynamicMethodInvocation {


    public static void main(String[] args) {


      /*  for (int i = 0; i < 10; i++) {
            Animal a = getRandomAnimal();
            a.saySomething();
        }*/


        Animal myDog = new Dog();

        if (myDog instanceof Dog) {
            ( (Dog)myDog ).sayHello();
        }

    }

    private static Animal getRandomAnimal() {
        if (new Random().nextBoolean()) {
            return new Dog();
        } else {
            return new Fish();
        }
    }
}
