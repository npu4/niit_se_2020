package com.company;


public class Main {

    public static void main(String[] args) {
        double[] array = new double[10];
        final double max = 2147483647;
        final double min = -2147483647;

        for (int y = 0; y < 10; y++) {
            double x = (Math.random() * ((max - min) + 1)) + min;
            array[y] = x;
        }
        System.out.println(java.util.Arrays.toString(array));
        for (int i = 0; i < 9; i++) {
            if (array[i] > 0) {
                if (array[i + 1] < 0) {
                    System.out.println("Числа с противоположным знаком обнаружены:     " + array[i] + "         " + array[i + 1]);
                }
            }
            if (array[i] < 0) {
                if (array[i + 1] > 0) {
                    System.out.println("Числа с противоположным знаком обнаружены       " + array[i] + "           " + array[i + 1]);
                }
            }
        }
    }

}
