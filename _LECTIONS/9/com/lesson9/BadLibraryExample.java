package com.lesson9;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class BadLibraryExample {


    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) throws IOException {


        final Person vasya = new Person("Vasya");
        toJson(vasya, new FileOutputStream("вася.txt"));
        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        toJson(vasya, stream);

        System.out.println(stream.toByteArray().length);


        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(outputStream);
        toJson(vasya,  outputStream);


        byte[] bytes = new byte[200];
        in.read(bytes);


        System.out.println(new String(bytes));

    }




    public static void toJson(Person person, OutputStream stream) {
        String value = String.format("{name:\"%s\"}", person.name);
        try {
            stream.write(value.getBytes());
        } catch (IOException e) {
            System.out.println("Не удалось записать");
        }
    }


}
