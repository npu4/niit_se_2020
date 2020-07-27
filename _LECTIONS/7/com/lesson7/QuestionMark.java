package com.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionMark {


    public static void main(String[] args) {


        List<Object> anyObjects = new ArrayList<>();
        addRandomObject(anyObjects);
        addRandomObject(anyObjects);
        addRandomObject(anyObjects);


        System.out.println(anyObjects);


        List<?> anotherAnyObject = new ArrayList<>();

       // addRandomObject(anotherAnyObject); не работает, т.к. в коллекции может лежать любой тип, но тольо один
    }


    static void addRandomObject(List<Object> toAdd) {
        if (new Random().nextBoolean()) {
            toAdd.add("String");
        } else {
            toAdd.add(false);
        }
    }

}
