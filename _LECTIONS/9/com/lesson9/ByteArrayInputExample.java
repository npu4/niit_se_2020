package com.lesson9;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class ByteArrayInputExample {


    public static void main(String[] args) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{68, 69, 70});
        System.out.println(readInputToString(in));

        System.out.println(readInputToString(new FileInputStream("C:\\programming\\niit_se_2020\\text-file.txt")));
        System.out.println(readInputToString(URI.create("https://ya.ru").toURL().openStream()));



    }


    public static String readInputToString(InputStream ios ) throws IOException {
        byte[] result = new byte[1000];
        ios.read(result);
        return new String(result);
    }
}
