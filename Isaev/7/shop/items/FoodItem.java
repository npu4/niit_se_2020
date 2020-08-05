package shop.items;

import java.util.Random;

public class FoodItem extends ShopItem {

    private static int calorieValue;
    private static int expirationDateDays;
    private static final int[] expirationDates = {30, 20, 40, 10};
    private static final int[] ccalories = {50, 35, 60, 100};
    private static final int[] prices = {10, 15, 20, 40};

    public FoodItem(String itemName) {
        super(itemName, prices[new Random().nextInt(prices.length - 1)]);
        calorieValue = ccalories[new Random().nextInt(ccalories.length - 1)];
        expirationDateDays = expirationDates[new Random().nextInt(expirationDates.length - 1)];
    }

    public int getCalorieValue() {
        return calorieValue;
    }

    public int getExpirationDateDays() {
        return expirationDateDays;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "calorieValue=" + calorieValue +
                ", expirationDateDays=" + expirationDateDays +
                '}';
    }
}
