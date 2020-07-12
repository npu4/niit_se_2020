package com.niit.isaev.FruitAmbiguity.fruits;

public class Orange extends Fruit {

    int skinThickness = random.nextInt(20);

    @Override
    public String toString() {
        return Orange.class.getSimpleName() + " weights " + fruitWeight + " grams and has skin thickness "+skinThickness;
    }

}
