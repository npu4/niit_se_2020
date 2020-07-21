package com.niit.lesson5;

public class AnotherClass {
    public static void main(String[] args) {
        Animal anotherAnimal = new Animal();
        anotherAnimal.defaultVisiblity = "the same package";
        anotherAnimal.protectedField = "protected field is available";


        System.out.println(anotherAnimal.protectedField);


    }
}
