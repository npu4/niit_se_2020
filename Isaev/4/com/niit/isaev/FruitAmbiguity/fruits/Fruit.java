package com.niit.isaev.FruitAmbiguity.fruits;

import java.util.Random;

public class Fruit {
    Random random = new Random();
    int fruitWeight = random.nextInt(1000);



    @Override
    public String toString() {
        return "Fruit weight = "+fruitWeight;
    }

}


