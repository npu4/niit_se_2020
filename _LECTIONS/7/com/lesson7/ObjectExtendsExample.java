package com.lesson7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectExtendsExample {

    public static void main(String[] args) {


        List<Object> objects = new ArrayList<>();
        List<Serializable> comparable = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        List<Integer> integers= new ArrayList<>();


        List<? extends Number> numbersAndDescedants = numbers;
        List<? extends Number> numbersAndDescedants1 = integers;
       // List<? extends Number> numbersAndDescedants2 = comparable; не работает


        List<? super Number> numbersAndAncestors = numbers;
        List<? super Number> numbersAndAncestors1 = comparable;
        List<? super Number> numbersAndAncestors2 = objects;






    }
}
