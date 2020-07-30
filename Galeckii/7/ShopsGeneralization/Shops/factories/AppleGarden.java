package Shops.factories;

import Shops.items.Apple;

import java.util.Collection;
import java.util.Random;

public class AppleGarden {
    public static void fillShopWithApples(Collection<? super Apple> shop) {
        StringBuilder appleList = new StringBuilder();
        for (int i = 0; i < new Random().nextInt(3) + 2; i++) {
            shop.add(addApple(appleList));
        }
        System.out.println("В магазин добавлены яблоки: " +
                appleList
                        .deleteCharAt(appleList.length() - 1)
                        .deleteCharAt(appleList.length() - 1)
                        .toString());
    }

    private static Apple addApple(StringBuilder appleList) {
        switch (new Random().nextInt(3)) {
            case (0):
                appleList.append("Antonovka, ");
                return new Apple("Antonovka", 30, 10, 20, "Yellow");
            case (1):
                appleList.append("Borovinka, ");
                return new Apple("Borovinka", 20, 5, 40, "Red");
            case (2):
                appleList.append("Sharopay, ");
                return new Apple("Sharopay", 40, 14, 30, "Red-green");
            default:
                return null;
        }
    }
}
