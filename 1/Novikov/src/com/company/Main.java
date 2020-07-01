package com.company;

public class Main {

    public static void main(String[] args) {

        int a=5;
        int b=6;
        int c=a+b;

    if(a>b){
        System.out.println("Число a больше числа b");
    }
    else if(b>a){
        System.out.println("Число a меньше числа b");
    }
   else if(a==b){
            System.out.println("Число a равно b");
    }


        System.out.println("Сумма a и b равна "+ c);
    }
}
