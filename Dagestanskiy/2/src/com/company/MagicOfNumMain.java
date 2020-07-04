package com.company;
import java.util.Random;

public class MagicOfNumMain {

    public static void main(String[] args) {
        int arraynums[] = new int[100];
        Random myrandom = new Random();
        for (int i=0; i<100; i++){
            // записываем в массив случайные целые числа в
            // интервале от (-100;100) не включая -100 и 100
            arraynums[i] = myrandom.nextInt(199) - 99;
            if(isMagicNumber(arraynums[i])){
                System.out.printf("Число %3d - магическое! %n",arraynums[i]);
            }
        }

    }

    static boolean isMagicNumber(int number) {
        if (number > -10 & number < 10){
            return false;
        } else if ((int) (number / 10) == number % 10) {
            return true;
        } else {
            return false;
        }
    }
}
