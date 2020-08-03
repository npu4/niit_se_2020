package com.lesson9;

import java.io.File;

public class FileExample {

    public static void main(String[] args) {
        File f = new File("1/2/3/4/new file");
        if (!f.exists()) {
            System.out.println("Файла нет, создаем");

            System.out.println(f.mkdirs());
        }
    }
}
