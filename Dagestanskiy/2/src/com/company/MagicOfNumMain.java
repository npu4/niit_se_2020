package com.company;
import java.util.Random;

public class MagicOfNumMain {

    public static void main(String[] args) {
        int arrayNums[] = new int[100];
        Random myRandom = new Random();
        for (int i=0; i<100; i++){
            // записываем в массив случайные целые числа в
            // интервале от (-100;100) не включая -100 и 100
            arrayNums[i] = myRandom.nextInt(199) - 99;
            if(isMagicNumber(arrayNums[i])){
                System.out.printf("Число %3d - магическое! %n",arrayNums[i]);
            }
        }

    }

    static boolean isMagicNumber(int number) {
        if (number > -10 & number < 10){
            return false;
        }
        return number / 10 == number % 10 ;
    }
}
