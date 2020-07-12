package com.niit.isaev.FruitAmbiguity.fruits;

public class Apple extends Fruit{
    String[] appleColors = {"red","green","yellow"};

    String color = appleColors[random.nextInt(appleColors.length)];

    @Override
    public String toString() {
        return Apple.class.getSimpleName() + " weights " + fruitWeight + " grams and has color "+color;
    }
}
