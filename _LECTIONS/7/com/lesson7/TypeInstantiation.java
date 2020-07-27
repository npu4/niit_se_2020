package com.lesson7;

import java.util.ArrayList;
import java.util.List;

public class TypeInstantiation {


    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(42d);

        List<Integer> ints = new ArrayList<>();



        //numbers = ints; не работает, т.к. List<Integer> не является наследников List<Number>
    }
}
