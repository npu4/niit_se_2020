package com.niit.lesson5.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CheckedException {


    public static void main(String[] args) {
        try {
            final String content = getString();
            System.out.println(content);
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет");
        } catch (IOException e) {
            System.out.println("Ошибка ввода / вывода");
        }
        System.out.println("Конец");
    }

    private static String getString() throws IOException {
        FileReader fr = new FileReader("text-file.txt");
        char[] text = new char[10];
        fr.read(text);
        return new String(text);
    }

}
