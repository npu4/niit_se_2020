package org.apache.commons;

public class ItemSorters {

    static int sortByCategory(ShopItem itemOne, ShopItem itemTwo) {
        return itemOne.getCategory().compareTo(itemTwo.getCategory());
    }

    static int sortByTitle(ShopItem itemOne, ShopItem itemTwo) {
        return itemOne.getTitle().compareTo(itemTwo.getTitle());
    }

    static int sortByPrice(ShopItem itemOne, ShopItem itemTwo) {
        return Double.compare(itemOne.getPrice(), itemTwo.getPrice());
    }

    static int sortByQuantity(ShopItem itemOne, ShopItem itemTwo) {
        return Integer.compare(itemOne.getQuantity(), itemTwo.getQuantity());
    }

}
