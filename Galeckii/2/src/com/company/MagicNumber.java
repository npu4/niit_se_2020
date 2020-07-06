package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class MagicNumber {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i : array) {
            array[i] = ThreadLocalRandom.current().nextInt(-100, 101);
            if (isMagicNumber(array[i])) {
                System.out.println("Число " + array[i] + " - магическое!");
            }
        }
    }

    public static boolean isMagicNumber(int number){
        return number / 10 == number % 10;
    }
}
