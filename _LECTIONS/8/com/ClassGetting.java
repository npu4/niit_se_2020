package com;

import java.lang.reflect.Field;

public class ClassGetting {


    public static void main(String[] args) {
        /*printFullClassName("asd");
        printFullClassName(42);
        printFullClassName(42L);*/


        printClassFields(PersonRefl.class);
        printClassFields(PersonWithAddress.class);
    }


    static void printFullClassName(Object o) {
        final Class<?> aClass = o.getClass();
        System.out.println(aClass.getName());
    }

    static void printClassFields(Class<?> someClass) {
        final Field[] fields = someClass.getDeclaredFields();
        System.out.println(fields.length);

        for (Field field : fields) {
            System.out.println(field.getName() + ":" + field.getType() );
        }


        final Class<?> superclass = someClass.getSuperclass();
        System.out.println(String.format(" У класса %s родительский класс %s ", someClass.getSimpleName(), superclass.getSimpleName() ));


    }


}
