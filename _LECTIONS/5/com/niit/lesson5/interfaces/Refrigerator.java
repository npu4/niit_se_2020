package com.niit.lesson5.interfaces;

public class Refrigerator implements Storage {
    final int maxCapacity;
    int currentCapacity;

    public Refrigerator(int maxCapacity, int currentCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    @Override
    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public void loadSomething(int i) {
        currentCapacity += i;
        System.out.println("Положена вещь весом " + i + ", общая загрузка " + currentCapacity);
    }
}
