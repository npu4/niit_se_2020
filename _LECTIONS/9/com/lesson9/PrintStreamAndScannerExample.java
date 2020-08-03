package com.lesson9;

import java.util.Scanner;

public class PrintStreamAndScannerExample {


    public static void main(String[] args) throws InterruptedException {
        System.out.print("Введите число");


        Thread.sleep(1000);


        try (Scanner sc = new Scanner(System.in)) {
            final long number = sc.nextLong();
            System.out.println(number);

        }

    }
}
