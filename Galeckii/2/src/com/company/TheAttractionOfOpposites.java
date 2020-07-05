package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class TheAttractionOfOpposites {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.println(array[i]);
        }

        for (int i = 0; i < 9; i++) {
            if (array[i] != 0 && array[i + 1] != 0 && isNumbersDifferentSign(array[i], array[i + 1])) {
                System.out.println("Числа с противоположными знаками обнаружены: " + array[i] + " и " + array[i + 1]);
            }
        }
    }

    public static boolean isNumbersDifferentSign(int first, int second) {
        return (first > 0 && second < 0) || (first < 0 && second > 0);
    }
}
