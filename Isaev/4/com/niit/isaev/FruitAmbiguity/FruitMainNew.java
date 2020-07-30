package com.niit.isaev.FruitAmbiguity;

import com.niit.isaev.FruitAmbiguity.fruits.Apple;
import com.niit.isaev.FruitAmbiguity.fruits.Fruit;
import com.niit.isaev.FruitAmbiguity.fruits.Orange;
import com.niit.isaev.FruitAmbiguity.fruits.Pineapple;

import java.util.Random;

public class FruitMainNew {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[4];
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = getRandomFruit();

        }
        for(Fruit fruit: fruits){
            System.out.println(fruit.toString());
        }
    }
       public static Fruit getRandomFruit (){
            Random random = new Random();
            int numberOfFruit = random.nextInt(3);
            switch (numberOfFruit){
                case 0:
                    return new Apple();
                case 1:
                    return new Orange();
                case 2:
                    return new Pineapple();

            } return null;
        }
}
