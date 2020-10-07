package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.frameworks.Shop;
import org.example.frameworks.ShopItem;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Collection<ShopItem> shopItems = new ArrayList<>();
        String forID = "ABCDEFGHIGKLMNOPQRSTUVWXYZ1234567890";
        shopItems.add(new ShopItem("продукты", 12, "яблоко", 10, RandomStringUtils.random(25, forID)));
        shopItems.add(new ShopItem("продукты", 50, "макароны", 14, RandomStringUtils.random(25, forID)));
        shopItems.add(new ShopItem("продукты", 100, "виноград", 1000, RandomStringUtils.random(25, forID)));
        shopItems.add(new ShopItem("химия", 45, "мыло", 34, RandomStringUtils.random(25, forID)));
        shopItems.add(new ShopItem("химия", 250, "шампунь", 22, RandomStringUtils.random(25, forID)));
        shopItems.add(new ShopItem("химия", 120, "гель", 13, RandomStringUtils.random(25, forID)));
        shopItems.add(new ShopItem("одежда", 3000, "кофта", 3, RandomStringUtils.random(25, forID)));
        shopItems.add(new ShopItem("одежда", 2500, "блуза", 7, RandomStringUtils.random(25, forID)));
        shopItems.add(new ShopItem("одежда", 2000, "юбка", 5, RandomStringUtils.random(25, forID)));
        shopItems.add(new ShopItem("одежда", 2200, "шорты", 2, RandomStringUtils.random(25, forID)));

        Shop shop = new Shop(shopItems);

        shop.randomSort();
    }
}
