package com;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreationByStringExample {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        final Class<?> aClass = Class.forName("com.PersonRefl");


        final Object o = aClass.newInstance();

        final Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.getType() == String.class) {
                declaredField.set(o, "Some string value");
            }
        }


        final Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            final boolean isIntClass = declaredMethod.getParameters().length > 0 &&
                    declaredMethod.getParameters()[0].getType() == int.class;

            if (declaredMethod.getParameters().length == 1 && isIntClass
                    && declaredMethod.getName().equals("setAge")
            ) {
                declaredMethod.invoke(o, 42);
            }
        }


        System.out.println(o);

        final Method ageMethod = aClass.getDeclaredMethod("getAge");
        ageMethod.setAccessible(true);
        System.out.println("Возраст через геттер:" + ageMethod.invoke(o));





    }
}
