package com.lesson11;




public interface Animal {


    String getName();


    String getAge();

    default void sayHello() {
        System.out.println("Привет, я - " + getName());
    }

    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();



        cat.sayHello();
        dog.sayHello();
    }

    interface Greeter {
        default void sayHello() {
            System.out.println("Hola!");
        }
    }



    static class Cat implements Animal, Greeter {




        @Override
        public String getName() {
            return "Кот";
        }

        @Override
        public String getAge() {
            return "3";
        }

        @Override
        public void sayHello() {
            Greeter.super.sayHello();
        }
    }

    static class Dog implements Animal {

        @Override
        public String getName() {
            return "Собака";
        }

        @Override
        public String getAge() {
            return null;
        }
    }
}
