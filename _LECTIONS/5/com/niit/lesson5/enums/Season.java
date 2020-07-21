package com.niit.lesson5.enums;

public enum Season {
    SUMMER, WINTER;


    public static void main(String[] args) {


        Season someSeason = Season.SUMMER;
        System.out.println(getAverageTemp(someSeason));
        System.out.println(getAverageTemp(Season.WINTER));
    }

    public static int getAverageTemp(Season season) {
        switch (season) {
            case SUMMER:
                return 10;
            case WINTER:
                return -10;
        }

        return 0;
    }
}
