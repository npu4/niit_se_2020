package com.niit.isaev.FruitAmbiguity;


import com.niit.isaev.FruitAmbiguity.fruits.Apple;
import com.niit.isaev.FruitAmbiguity.fruits.Fruit;
import com.niit.isaev.FruitAmbiguity.fruits.Orange;
import com.niit.isaev.FruitAmbiguity.fruits.Pineapple;

import java.util.Random;

public class FruitMain {
    Random random = new Random();
    Fruit[] fruits = new Fruit[4];







    Fruit getRandomFruit(){
        int numberOfFruit = random.nextInt(3);
        switch (numberOfFruit){
            case 1:
                return new Apple();
            case 2:
                return new Orange();
            case 3:
                return new Pineapple();
        } return null;
    }



}

