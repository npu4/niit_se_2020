package shop.fabrics;

import shop.items.FoodItem;
import shop.products.Apple;
import shop.products.Bread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class FoodFactory {

    public void fillShopWithFood(Collection<? super FoodItem> list, int numberOfFood) {
        List<String> apples = new ArrayList<>();
        int breadsWeight = 0;

        for (int i = 0; i < numberOfFood; i++) {
            FoodItem food = getRandomFood();
            if (food.getClass().getSimpleName().equals("Apple")) {
                list.add(food);
                Apple apple = (Apple) food;
                apples.add(apple.getColor());
            } else {
                list.add(food);
                Bread bread = (Bread) food;
                breadsWeight += bread.getWeightInGrams();
            }
        }

        System.out.println("Добавлено яблок - " + apples + ", хлеба - " + breadsWeight);
    }

    FoodItem getRandomFood() {
        int random = new Random().nextInt(2);
        switch (random) {
            case 0:
                return new Apple();
            case 1:
                return new Bread();
        }
        return null;
    }
}
