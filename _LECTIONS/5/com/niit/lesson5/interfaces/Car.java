package com.niit.lesson5.interfaces;

public interface Car {

    String DEFAULT_CAR_NAME = "Toyota";
    int getSpeed();

    default String getCarName() {
        return DEFAULT_CAR_NAME;
    }

    default void moveTo(String destination) {
        System.out.println("Машина" + getCarName() + " едет " + destination);
    }
}
