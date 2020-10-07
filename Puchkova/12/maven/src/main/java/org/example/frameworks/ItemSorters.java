package org.example.frameworks;

public class ItemSorters {
    static int sortByCategory(ShopItem shopItem1, ShopItem shopItem2) {
        return shopItem1.getCategory().compareTo(shopItem2.getCategory());
    }

    static int sortByTitle(ShopItem shopItem1, ShopItem shopItem2) {
        return shopItem1.getTitle().compareTo(shopItem2.getTitle());
    }

    static int sortByPrice(ShopItem shopItem1, ShopItem shopItem2) {
        if (shopItem1.getPrice() - shopItem2.getPrice() > 0) {
            return 1;
        } else {

            return -1;
        }
    }

    static int sortByQuantity(ShopItem shopItem1, ShopItem shopItem2) {
        return shopItem1.getQuantity() - shopItem2.getQuantity();
    }
}
