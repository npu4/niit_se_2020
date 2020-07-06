package com.company;



public class Main2 {

    public static boolean isMagicNumber(int number) {
        if(number % 10 == number /10 & number !=0) {
            System.out.println("Число: " + number + " магическое!");
        }
        return true;
    }



    public static void main(String[] args) {
        final int min = -100;
        final int max = 100;
        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            int x = (int)(Math.random() * ((max - min) - 1)) + min;
            array[i] = x;

        }
        for (int i = 0; i < 100; i++) {
            isMagicNumber(array[i]);
            // System.out.println(java.util.Arrays.toString(array));
        }
    }
}
