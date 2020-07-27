package com.lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.ls.LSOutput;

public class ZooExample {


    static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }
    }

    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        public void meow() {
            System.out.println("Мяу");
        }
    }

    static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        public void gav() {
            System.out.println("Гав");
        }
    }


    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        cats.addAll(Arrays.asList(new Cat("Васька"), new Cat("Барсик")));


        printAnimalsName(cats);
        //addDog(cats);

     /*   for (Cat cat : cats) {
            cat.meow();
        }*/



        List<Animal> zoo = new ArrayList<>();


    }

    public static void printAnimalsName(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.name);
        }

        final Animal someAnimal = new Animal("Барсик 2");
    }

    public static void addDog(List<? super Animal> animals) {
        animals.add(new Dog("Шарик"));
    }
    public static void addCat(List<? super Animal> animals) {
        animals.add(new Cat("Шарик"));
    }

}
