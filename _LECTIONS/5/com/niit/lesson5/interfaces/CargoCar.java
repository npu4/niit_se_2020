package com.niit.lesson5.interfaces;

public class CargoCar implements Storage, Car {

    private int speed;
    private String name;
    private int maxCapacity;
    private int currentCapacity;


    public CargoCar(int speed, String name, int maxCapacity, int currentCapacity) {
        this.speed = speed;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getCarName() {
        return name;
    }

    @Override
    public void moveTo(String destination) {
        System.out.println("Машина едет в " + destination);
    }

    @Override
    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public void loadSomething(int amountToLoad) {
        currentCapacity += amountToLoad;
    }
}
