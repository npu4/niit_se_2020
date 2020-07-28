package org.serieznyi.shop.item.food;

import org.serieznyi.shop.item.FoodItem;

final public class Apple extends FoodItem {
    private final Color color;

    public Color getColor() {
        return color;
    }

    enum Color {
        RED, GREEN, YELLOW
    }

    public Apple(String name, int price, int calorific, int expirationDateInDays, Color color) {
        super(name, price, calorific, expirationDateInDays);
        this.color = color;
    }
}
