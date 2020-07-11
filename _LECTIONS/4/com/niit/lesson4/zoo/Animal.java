package com.niit.lesson4.zoo;

public class Animal {
    String name;
    int weight;


    Animal(String name,int weight) {
        this.name = name;
        this.weight = weight;
        System.out.println("Создается животное");
    }

    public void sayHello() {
        System.out.println("Привет, я " + name);
    }



    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 2);

        Dog dog = new Dog("Sharik",4);

/*

        System.out.println(cat.name);
        System.out.println(dog.name);

*/

        cat.sayHello();
       /* dog.sayHello();


        cat.meow();
        dog.gav();


        dog.printWeightBeforeHello();

        cat.printName();*/

    }
}


class Cat extends Animal {



    public Cat(String name,int weight) {
        super(name,weight);
        System.out.println("Создается кот");

    }

    void meow() {
        System.out.println("Кошка по имени " + name + " говорят: Мяу ");
    }


    @Override
    public void sayHello() {
        System.out.println("Привет, я кошка по имени " + name);
        super.sayHello();
    }
}


class Dog extends Animal {

    public Dog(String name,int weight) {
        super(name,weight);
        System.out.println("Создается собака");
    }

    void gav() {
        System.out.println("Собака по имени " + name + " говорят: Гав ");
    }

    void printWeightBeforeHello() {
        System.out.println("Вес собаки " + weight);
        super.sayHello();
    }


}
