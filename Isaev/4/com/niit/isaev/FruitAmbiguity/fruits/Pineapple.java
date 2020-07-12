package com.niit.isaev.FruitAmbiguity.fruits;

public class Pineapple extends Fruit{

    int tailHeight = (int) (5+ Math.random()*15);

    @Override
    public String toString() {
        return Pineapple.class.getSimpleName() + "weights " + fruitWeight + "grams and has tail height "+tailHeight;
    }

}
