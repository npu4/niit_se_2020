package com;

import java.lang.reflect.Modifier;

public class ModifiersSample {


    public static void main(String[] args) throws NoSuchMethodException {


        final int getAge = PersonRefl.class.getDeclaredMethod("getName").getModifiers();
        System.out.println(Modifier.isPublic(getAge));
    }

}
