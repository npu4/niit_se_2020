package com.lesson9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;

public class BufferedOutputStreamSample {


    public static void main(String[] args) throws IOException {

        OutputStream out = new java.io.BufferedOutputStream(new FileOutputStream("buffered-sample.txt"));
        out.write(66);
        out.write(67);
        out.write(68);

        //out.flush(); // не работает без flush - файл пустой

    }
}
