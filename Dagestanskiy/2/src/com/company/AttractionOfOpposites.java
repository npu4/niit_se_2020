package com.company;
import java.util.Random;
import static java.lang.Integer.signum;

public class AttractionOfOpposites {

    public static void main(String[] args) {
        int arraynums[] = new int[10];
        Random myrandom = new Random();
        for (int i=0; i<10; i++){
            // записываем в массив случайные целые числа в
            // интервале генератора
            arraynums[i] = myrandom.nextInt();
            System.out.printf(" Элемент массива %2d : %15d  %n",i+1,arraynums[i]);
        }
        for (int i=0; i<9; i++){
            if(ArrCompare(arraynums[i],arraynums[i+1])){
                System.out.printf("Числа с противоположными знаками обнаружены: %15d  %15d %n",
                        arraynums[i], arraynums[i+1]);
            }
        }
    }

     static boolean ArrCompare(int a , int b) {
        if (Integer.signum(a)*Integer.signum(b)  < 0 ){
            return true;
        } else {
            return false;
        }
    }




}
