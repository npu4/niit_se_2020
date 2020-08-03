package com.lesson9;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ByteArrayOutputStreamExample {


    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();


        bos.write(65);
        bos.write(66);
        bos.write(67);


        final byte[] bytes = bos.toByteArray();


        System.out.println(new String(bytes));

        bos.writeTo(new FileOutputStream("file from array.txt"));

    }
}
