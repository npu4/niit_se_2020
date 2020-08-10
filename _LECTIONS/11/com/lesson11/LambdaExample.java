package com.lesson11;

import java.awt.print.Printable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.lesson11.Animal.Cat;

public class LambdaExample {


    public static void main(String[] args) {
        List<String> names = Arrays.asList("Вася", "Петя", "Яна");

        names.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println(names);


        Animal cat = new Cat();


        printAnimalDescription(cat, a -> System.out.println("Животное с именем " + a.getName()));
        printAnimalDescription(cat, a -> System.out.println("Животное с возрастом " + a.getAge()));


    }





    public static void printAnimalDescription(Animal a, PrintableAnimal descriptor) {
        descriptor.describeAnimal(a);
    }


    public interface PrintableAnimal {
        void describeAnimal(Animal a);
    }

}
