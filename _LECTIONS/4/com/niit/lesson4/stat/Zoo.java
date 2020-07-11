package com.niit.lesson4.stat;

import java.io.File;
import java.util.Random;

public class Zoo {

    static int createdZoos = getCreatedZoos();
    final String name;
    final int randomVar;

    static {
        if (new File("zoo").mkdir()) {
            System.out.println("Создали папку zoo");
        } else {
            System.out.println("Папка zoo уже существует");
        }
    }


    // блок нициализации вызывается при создании каждого объекта
    {
        final Random random = new Random();
        randomVar = random.nextInt();
    }

    public Zoo(String name) {
        this.name = name;
        createdZoos++;
    }

    public static String proposeZooName() {
        return "Мишутка";
    }


    public static int getCreatedZoos() {
        return createdZoos;
    }


    public int getRandomVar() {
        return randomVar;
    }
}
