package org.serieznyi.shop.item;

import org.serieznyi.shop.util.Assert;

abstract public class FoodItem extends ShopItem {
    private final int calorific;
    private final int expirationDateInDays;

    protected FoodItem(String name, int price, int calorific, int expirationDateInDays) {
        super(name, price);

        Assert.greaterThan(calorific, 0);
        this.calorific = calorific;

        Assert.greaterThan(expirationDateInDays, 0);
        this.expirationDateInDays = expirationDateInDays;
    }

    public int getCalorific() {
        return calorific;
    }

    public int getExpirationDateInDays() {
        return expirationDateInDays;
    }
}
