package com.company;

public class TVMain {


    public static void main(String[] args) {

        TV firstTV = new TV();

        String channel = "1-st channel";

        firstTV.currentChannel = channel;
        firstTV.currentVolume = 100;
        firstTV.isTurnedOn = true;
        //firstTV.isTurnedOn = 1; - не работает из-за проверки типов


        /*System.out.println("Текущий channel:" + firstTV.currentChannel);
        System.out.println("Текущая громкость:" + firstTV.currentVolume);
        System.out.println("Включен?" +firstTV.isTurnedOn);*/


        TV secondTV = new TV();
        secondTV.isTurnedOn = true;
        secondTV.currentChannel = "Another Channel";
        System.out.println("Текущий канал первого телевизора:" + firstTV.currentChannel);
        System.out.println("Текущий канал второго телевизора телевизора:" + secondTV.currentChannel);


        TV.DEFAULT_CHANNEL = "Updated channel";

        System.out.println("DEFAULT_CHANNEL  первого телевизора:" + TV.DEFAULT_CHANNEL);
        System.out.println("DEFAULT_CHANNEL второго телевизора телевизора:" + TV.DEFAULT_CHANNEL);


    }


}
