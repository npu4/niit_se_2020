package shop.factories;

import shop.items.*;

import java.util.ArrayList;
import java.util.Collection;

import static shop.factories.AppleGarden.fillShopWithApples;
import static shop.factories.BreadFactory.fillShopWithBreads;

public class FoodFactory {
    public static void fillShopWithFood(Collection<? super FoodItem> shopItems){
        Collection<FoodItem> foodItems = new ArrayList<>();
        fillShopWithApples(foodItems);
        fillShopWithBreads(foodItems);
        shopItems.addAll(foodItems);
    }
}
