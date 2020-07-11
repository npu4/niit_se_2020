package com.company;

import java.util.Random;

import static java.lang.Integer.signum;

public class AttractionOfOpposites {

    public static void main(String[] args) {
        int arrayNums[] = new int[10];
        Random myRandom = new Random();
        for (int i = 0; i < 10; i++) {
            // записываем в массив случайные целые числа в
            // интервале генератора
            arrayNums[i] = myRandom.nextInt();
            System.out.printf(" Элемент массива %2d : %15d  %n", i + 1, arrayNums[i]);
        }
        for (int i = 0; i < 9; i++) {
            if (arrCompare(arrayNums[i], arrayNums[i + 1])) {
                System.out.printf("Числа с противоположными знаками обнаружены: %15d  %15d %n",
                        arrayNums[i], arrayNums[i + 1]);
            }
        }
    }

    static boolean arrCompare(int a, int b) {
         return Integer.signum(a) * Integer.signum(b) < 0 ;
    }


}
