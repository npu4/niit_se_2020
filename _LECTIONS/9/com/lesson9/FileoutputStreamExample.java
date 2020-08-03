package com.lesson9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileoutputStreamExample {


    public static void main(String[] args) throws IOException {

        byte[] array = new byte[]{65,};
        final FileOutputStream fos = new FileOutputStream("file-to-write.txt");

        try {
            for (byte b : array) {
                fos.write(b);
            }
        } catch (IOException e) {
            System.out.println("Не удалось записать");
        } finally {
           /* try {
                fos.close();
            } catch (IOException e) {
                System.out.println("Не удалось закрыть соединение");
            }*/
        }

    /*    final FileOutputStream fileOutputStream = new FileOutputStream("file-to-write.txt");

        try (FileOutputStream fos = fileOutputStream;) {
            for (byte b : array) {
                fos.write(b);
            }
        }*/
    }
}
