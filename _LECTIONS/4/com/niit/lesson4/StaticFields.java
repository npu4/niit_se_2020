package com.niit.lesson4;

import java.util.Random;

public class StaticFields {

    static String SOME_CONSTANT = "42";
    final String instanceVariable;

    public StaticFields() {
        instanceVariable = "24";
    }

    public StaticFields(String finalVariableValue) {
        instanceVariable = finalVariableValue;


        //final int someLocalVariable = 42;
        final int someLocalVariable;


        if (new Random().nextBoolean()) {
            someLocalVariable = 2;
        } else {
            someLocalVariable = 4;
        }


        System.out.println(someLocalVariable);

    }






}
