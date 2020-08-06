package shop.products;

import shop.items.FoodItem;

import java.util.Random;

public class Apple extends FoodItem {
    private static final String DEFAULT_NAME = "Яблоко";

    private final String color;
    private final String[] colors = {"Зелёное", "Красное", "Жёлтое"};

    public Apple() {
        super(DEFAULT_NAME);
        this.color = colors[new Random().nextInt(colors.length - 1)];
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                '}';
    }
}
