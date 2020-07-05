package com.company;

    public class Main {
  static boolean isMagicNumber(int number ){
        boolean test;

        if((number/10==number%10)&&(number!=0))
            test=true;
        else
            test=false;

        return test;
    }


    public static void main(String[] args) {
        boolean test;

        Integer[] array= new Integer[100];
        for(int i=0; i<array.length; i++){
        array[i]=(int)(Math.random()*201-100);
        if(isMagicNumber(array[i])){
            System.out.println("Число "+ array[i] + " магическое!");
           }
        }
    }
}
