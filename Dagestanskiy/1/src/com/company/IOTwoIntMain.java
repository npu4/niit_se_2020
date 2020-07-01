package com.company;

import java.util.Scanner;

public class IOTwoIntMain {

    public static void main(String[] args) {

        int c = 0;
        Scanner read = new Scanner(System.in);
        System.out.print("Введите первое целое число: ");
        int a = read.nextInt();
        System.out.print("Введите второе целое число: ");
        int b = read.nextInt();

        if(a > b ) {
            System.out.println( "Число " + a + " ,больше " +b );
        }
        if(a < b ) {
            System.out.println( "Число " + a + " меньше " +b );
        }
        c = a + b;
        System.out.print( "Сумма чисел: " + c );

    }
}
