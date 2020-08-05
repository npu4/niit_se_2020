package shop.fabrics;

import shop.products.Apple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppleGarden {

    public void fillShowWithApples(Collection<? super Apple> list, int numberOfApples) {
        List<String> colorList = new ArrayList<>();
        for (int i = 0; i < numberOfApples; i++) {
            Apple apple = new Apple();
            list.add(apple);
            colorList.add(apple.getColor());
        }
        System.out.println("В магазин добавлены яблоки:" + colorList.toString());
    }
}
