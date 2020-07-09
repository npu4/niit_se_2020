package com.niit.lesson4;

public class Car {
    String name;
    String color;
    int hp;
    int maxSpeed;


    public Car(String name, String color, int hp, int maxSpeed) {
        this.name = name;
        this.color = color;
        this.hp = hp;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    public static void main(String[] args) {
        Car car1 = new Car("Audi","Red",200,200);
        Car car2 = new Car("BMW","white",200,201);


        System.out.println(car1.getMaxSpeed());
        System.out.println(car2.getMaxSpeed());
    }
}
