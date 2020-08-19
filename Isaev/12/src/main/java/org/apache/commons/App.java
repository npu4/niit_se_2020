package org.apache.commons;

import org.apache.commons.lang.StringUtils;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.addItem(new ShopItem("Электроника", "Телевизор", 25000.0));
        shop.addItem(new ShopItem("Электроника", "Холодильник", 30000.0));
        shop.addItem(new ShopItem("Электроника", "Ноутбук", 125000.0));
        shop.addItem(new ShopItem("Продукты", "Чай", 200.0));
        shop.addItem(new ShopItem("Продукты", "Кофе", 1000.0));
        shop.addItem(new ShopItem("Продукты", "Сахар", 70.0));
        shop.addItem(new ShopItem("Продукты", "Хлеб", 55.0));
        shop.addItem(new ShopItem("Химия", "Порошок", 300.0));
        shop.addItem(new ShopItem("Химия", "Хлорка", 30.0));

        shop.addComparator(ItemSorters::sortByCategory);
        shop.addComparator(ItemSorters::sortByPrice);
        shop.addComparator(ItemSorters::sortByQuantity);
        shop.addComparator(ItemSorters::sortByTitle);

        for (ShopItem item : shop.sortItem()) {
            System.out.println(String.format("%s - %s - %s - %f - %d",
                    StringUtils.abbreviate(item.getID(), 10),
                    StringUtils.abbreviate(item.getCategory(), 10),
                    StringUtils.abbreviate(item.getTitle(), 10),
                    item.getPrice(),
                    item.getQuantity()));
        }


    }
}
