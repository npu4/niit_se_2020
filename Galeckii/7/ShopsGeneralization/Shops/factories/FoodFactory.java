package Shops.factories;

import Shops.items.*;

import java.util.Collection;
import java.util.Random;

public class FoodFactory {
    static int totalWeight=0;
    public static void fillShopWithFood(Collection<? super FoodItem> shop) {
        StringBuilder colors = new StringBuilder();

        for (int i = 0; i < new Random().nextInt(3) + 2; i++) {
            shop.add(addFood(colors));
        }
        
        System.out.printf("В магазин добавлены яблоки: %sи хлеба общим весом: %d\n",
                colors.toString(), totalWeight);
        totalWeight=0;
    }

    private static FoodItem addFood(StringBuilder colors) {
        switch (new Random().nextInt(4)) {
            case (0):
                colors.append("Yellow, ");
                return new Apple("Antonovka", 30, 10, 20, "Yellow");
            case (1):
                colors.append("Borovinka, ");
                return new Apple("Borovinka", 20, 5, 40, "Red");
            case (2):
                totalWeight+=300;
                return new Bread("Borodinskiy", 20, 30, 5, 300);
            case (3):
                totalWeight+=200;
                return new Bread("Sovetskiy", 30, 40, 4, 200);
            default:
                return null;
        }
    }

}
