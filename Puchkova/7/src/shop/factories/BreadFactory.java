package shop.factories;

import shop.items.Bread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class BreadFactory {
    static final int MAX_NUM_OF_MAKING_ITEMS = 5;

    public static void fillShopWithBreads(Collection<? super Bread> shopItems){
        Collection<Bread> breads = makeBreads();
        shopItems.addAll(breads);
        Integer weight = 0;
        System.out.println("В магазин добавлен хлеб:");
        for (Bread bread : breads) {
            System.out.println(bread.getName());
            weight += bread.getWeight();
        }
        System.out.println("общим весом " + weight + " г");
        System.out.println();
    }

    static Collection<Bread> makeBreads(){
        int numOfBreads = new Random().nextInt(MAX_NUM_OF_MAKING_ITEMS) + 1;
        Collection<Bread> breads = new ArrayList<>();
        for (int i = 0; i < numOfBreads; i++) {
            breads.add(new Bread(new Random().nextInt(50)+20, new Random().nextInt(300)+100));
        }
        return breads;
    }
}
