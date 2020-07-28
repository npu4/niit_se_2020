package org.serieznyi.shop;

import org.serieznyi.shop.fabric.AppleGarden;
import org.serieznyi.shop.fabric.ElectronicFabric;
import org.serieznyi.shop.fabric.FoodFabric;
import org.serieznyi.shop.item.ElectronicItem;
import org.serieznyi.shop.item.FoodItem;
import org.serieznyi.shop.item.ShopItem;
import org.serieznyi.shop.item.food.Apple;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
  public static void main(String[] args) {
    Collection<ShopItem> hypermarket = new ArrayList<>();
    Collection<FoodItem> foodShop = new ArrayList<>();
    Collection<Apple> appleKiosk = new ArrayList<>();
    Collection<ElectronicItem> electronicShop = new ArrayList<>();

    System.out.println("Фабрика еды:");
    FoodFabric foodFabric = new FoodFabric();
    System.out.println("Заполняем продуктовый магазин");
    foodFabric.fillShopWithFood(foodShop);
    System.out.println("Заполняем гипермаркет");
    foodFabric.fillShopWithFood(hypermarket);
    System.out.println("----------------");

    System.out.println("Яблочный сад:");
    AppleGarden appleGarden = new AppleGarden();
    System.out.println("Заполняем продуктовый магазин");
    appleGarden.fillShopWithApples(foodShop);
    System.out.println("Заполняем гипермаркет");
    appleGarden.fillShopWithApples(hypermarket);
    System.out.println("Заполняем яблочный киоск");
    appleGarden.fillShopWithApples(appleKiosk);
    System.out.println("----------------");

    System.out.println("Фабрика электроприборов:");
    ElectronicFabric electronicFabric = new ElectronicFabric();
    System.out.println("Заполняем гипермаркет");
    electronicFabric.fillShopWithElectronicGoods(hypermarket);
    System.out.println("Заполняем магазин электроники");
    electronicFabric.fillShopWithElectronicGoods(electronicShop);
    System.out.println("----------------");

//    Создайте трех посетителей разных классов и пусть они погуляют по всем магазинам.
  }
}
