package com.lesson9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderSample {

    public static void main(String[] args) throws IOException {
        try (FileReader fr = new FileReader("C:\\programming\\niit_se_2020\\вася.txt")) {
            /*System.out.println((char) fr.read());
            System.out.println((char) fr.read());
            System.out.println((char) fr.read());
            System.out.println((char) fr.read());
            System.out.println((char) fr.read());
            System.out.println((char) fr.read());
            System.out.println((char) fr.read());
            System.out.println((char) fr.read());
            System.out.println((char) fr.read());
            System.out.println((char) fr.read());
            System.out.println((char) fr.read());*/


            final char[] cbuf = new char[100];
            fr.read(cbuf);
            System.out.println(Arrays.toString(cbuf));
        }
    }
}
