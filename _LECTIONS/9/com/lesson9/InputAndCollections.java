package com.lesson9;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


public class InputAndCollections {


    public static void main(String[] args) throws IOException {


        long now = System.currentTimeMillis();
        readArray();
        System.out.println("Чтение из массива заняло " + (System.currentTimeMillis() - now));



        now = System.currentTimeMillis();
        readByte();
        System.out.println("Чтение по байтам заняло " + (System.currentTimeMillis() - now));


    }

    private static void readArray() throws IOException {
        FileInputStream fs = new FileInputStream("C:\\programming\\lucene-demo\\src\\main\\resources\\War and Peace.txt");
        byte[] reads = new byte[2_000_000];

        final int read = fs.read(reads);
        System.out.println("Всего было прочитано байт " + read);

      //  System.out.println(new String(reads));


        fs.close();
    }


    private static void readByte() throws IOException {
       // FileInputStream fs = new FileInputStream("C:\\programming\\lucene-demo\\src\\main\\resources\\War and Peace.txt");
        InputStream fs = new BufferedInputStream(new FileInputStream("C:\\programming\\lucene-demo\\src\\main\\resources\\War and Peace.txt"));
        byte[] reads = new byte[2_000_000];
        int counter = 0;


        int readByte;
        while ((readByte = fs.read()) != -1) {
            reads[counter++] = (byte) readByte;
        }
        System.out.println("Всего было прочитано байт " + counter);


       // System.out.println(Arrays.toString(reads));
        // System.out.println(new String(reads));


        fs.close();
    }
}
