package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class ParameterNames {

    public static void main(String[] args) throws NoSuchMethodException {

        final Constructor<PersonRefl> constructor = PersonRefl.class.getConstructor(String.class, String.class, int.class);
        final Parameter parameter = constructor.getParameters()[1];
        System.out.println(parameter.getName());

    }
}
