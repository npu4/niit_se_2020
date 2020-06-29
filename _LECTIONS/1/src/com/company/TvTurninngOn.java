package com.company;

public class TvTurninngOn {

    public static void main(String[] args) {
        TV first = new TV();
        first.setLocation(" кухня ");
        System.out.println(first.getState());


        TV second =  new TV();
        second.setLocation(" гостинная ");
        first.turnOn();
        System.out.println(first.getState());

        System.out.println(second.getState());

        second.turnOn();
        System.out.println(second.getState());




    }
}
