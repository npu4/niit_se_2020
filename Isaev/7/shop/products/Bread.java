package shop.products;

import shop.items.FoodItem;

import java.util.Random;

public class Bread extends FoodItem {

    private static final String DEFAULT_NAME = "Хлеб";
    private final int weightInGrams;
    private final int[] weights = {50, 40, 30, 20};

    public Bread() {
        super(DEFAULT_NAME);
        this.weightInGrams = weights[new Random().nextInt(weights.length - 1)];
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }
}
