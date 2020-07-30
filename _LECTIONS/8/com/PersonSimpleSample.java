package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class PersonSimpleSample {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        final Class<PersonRefl> personReflClass = PersonRefl.class;

        final PersonRefl personRefl = personReflClass.newInstance();

        personRefl.name = "Vasya";
        System.out.println(personRefl);

        final Constructor<?>[] constructors = personReflClass.getConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.print(constructor.getParameterCount());
            final Class<?>[] parameterTypes = constructor.getParameterTypes();
            System.out.println(" " + Arrays.toString(parameterTypes));

            if (constructor.getParameterCount() == 3) {

                if (parameterTypes[0] == String.class &&
                        parameterTypes[1] == String.class &&
                        parameterTypes[2] == int.class ) {

                    Object[] arguments = {"Вася", "Пупкин", 18};
                    final PersonRefl o = (PersonRefl) constructor.newInstance(arguments);
                    System.out.println("Создали человека в помощью конструктора с термя аргументами " + o.toString());
                }
            }

        }




    }
}
