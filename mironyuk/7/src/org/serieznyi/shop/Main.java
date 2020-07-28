package org.serieznyi.shop;

import org.serieznyi.shop.fabric.AppleGarden;
import org.serieznyi.shop.fabric.ElectronicFabric;
import org.serieznyi.shop.fabric.FoodFabric;
import org.serieznyi.shop.factory.AppleFactory;
import org.serieznyi.shop.item.ElectronicItem;
import org.serieznyi.shop.item.FoodItem;
import org.serieznyi.shop.item.ShopItem;
import org.serieznyi.shop.item.food.Apple;
import org.serieznyi.shop.visitor.ElectronicAddictedVisitor;
import org.serieznyi.shop.visitor.ImJustLookingVisitor;
import org.serieznyi.shop.visitor.RichVisitor;
import org.serieznyi.shop.visitor.ShopVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<ShopVisitor> visitors = makeVisitors();
    List<Collection<? extends ShopItem>> shops = makeAndFillShops();

    System.out.println("Запускаем покупателей");
    for (ShopVisitor visitor : visitors) {
      for (Collection<? extends ShopItem> shop : shops) {
        visitor.visitShop(shop);
      }
    }
  }

  private static List<Collection<? extends ShopItem>> makeAndFillShops() {
    List<Collection<? extends ShopItem>> shops = new ArrayList<>();

    Collection<ShopItem> hypermarket = new ArrayList<>();
    shops.add(hypermarket);
    Collection<FoodItem> foodShop = new ArrayList<>();
    shops.add(foodShop);
    Collection<Apple> appleKiosk = new ArrayList<>();
    shops.add(appleKiosk);
    Collection<ElectronicItem> electronicShop = new ArrayList<>();
    shops.add(electronicShop);

    AppleFactory appleFactory = new AppleFactory();

    System.out.println("Фабрика еды:");
    FoodFabric foodFabric = new FoodFabric(appleFactory);
    System.out.println("Заполняем продуктовый магазин");
    foodFabric.fillShopWithFood(foodShop);
    System.out.println("Заполняем гипермаркет");
    foodFabric.fillShopWithFood(hypermarket);
    System.out.println("----------------");

    System.out.println("Яблочный сад:");
    AppleGarden appleGarden = new AppleGarden(appleFactory);
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

    return shops;
  }

  private static List<ShopVisitor> makeVisitors() {
    List<ShopVisitor> visitors = new ArrayList<>();
    visitors.add(new ElectronicAddictedVisitor());
    visitors.add(new ImJustLookingVisitor());
    visitors.add(new RichVisitor());

    return visitors;
  }
}
