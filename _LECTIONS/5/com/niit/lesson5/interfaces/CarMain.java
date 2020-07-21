package com.niit.lesson5.interfaces;

import java.util.Random;

public class CarMain {


    public static void main(String[] args) {
      /*  CargoCar car = new CargoCar(90, Car.DEFAULT_CAR_NAME, 10000, 0);
        loadStorage(car);
        moveCar(car);

        final Refrigerator toLoad = new Refrigerator(500, 0);
        loadStorage(toLoad);
        loadStorage(toLoad);*/


        moveCar(new ToytaCar());

    }


    public static void loadStorage(Storage toLoad) {
        final int i = new Random().nextInt(1000);
        System.out.println("Пытаюсь положить вещь весом " + i);

        if (i < toLoad.getMaxCapacity()) {
            System.out.println("Кладу вещь весом " + i);
            toLoad.loadSomething(i);
        } else {
            System.out.println("Вещь тяжелая");
        }
    }


    public static void moveCar(Car carToMove) {
        String[] destinations = {"Москва", "Нижний Новгород", "Самара"};
        carToMove.moveTo(destinations[new Random().nextInt(destinations.length)]);
    }


}
