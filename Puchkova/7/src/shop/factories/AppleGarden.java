package shop.factories;

import shop.items.Apple;
import shop.items.ColorOfApple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class AppleGarden {
    static final int MAX_NUM_OF_MAKING_ITEMS = 5;

    public static void fillShopWithApples(Collection<? super Apple> shopItems){
        Collection<Apple> apples = makeApples();
        shopItems.addAll(apples);
        System.out.println("В магазин добавлены яблоки:");
        for (Apple apple : apples) {
            System.out.println(apple.getName() + " " + apple.getColor());
        }
        System.out.println();
    }

    static Collection<Apple> makeApples(){
        int numOfApples = new Random().nextInt(MAX_NUM_OF_MAKING_ITEMS) + 1;
        ColorOfApple[] colors = ColorOfApple.values();
        Collection<Apple> apples = new ArrayList<>();
        for (int i = 0; i < numOfApples; i++) {
            int numOfColor = new Random().nextInt(ColorOfApple.values().length);
            apples.add(new Apple(new Random().nextInt(50)+20, colors[numOfColor]));
        }
        return apples;
    }
}
