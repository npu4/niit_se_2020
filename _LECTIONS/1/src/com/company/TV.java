package com.company;

public class TV {


    static String DEFAULT_CHANNEL = "DEFAULT_CHANNEL";

    String location;
    Integer currentVolume;
    Boolean isTurnedOn = false;
    String currentChannel;



    void setLocation(String newLocation) {
        location = newLocation;
        System.out.println("Переносим телевизор в " + newLocation);

    }


    String getState() {

        if (isTurnedOn) {
            return "Телевизора в " + location + " включен";
        } else {
            return "Телевизора в " + location + " выключен";
        }
    }

    void turnOff() {
        System.out.println("Телевизор в " + location + " выключается.");
        isTurnedOn = false;
    }


    void turnOn() {
        System.out.println("Телевизор в " + location + " включается.");
        isTurnedOn = true;
    }




}
