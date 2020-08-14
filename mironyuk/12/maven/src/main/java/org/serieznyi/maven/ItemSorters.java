package org.serieznyi.maven;

public class ItemSorters {
    static int sortByCategory(ShopItem a, ShopItem b) {
        return String.CASE_INSENSITIVE_ORDER.compare(a.getCategory(), b.getCategory());
    }

    static int sortByName(ShopItem a, ShopItem b) {
        return String.CASE_INSENSITIVE_ORDER.compare(a.getName(), b.getName());
    }

    static int sortByPrice(ShopItem a, ShopItem b) {
        return Double.compare(a.getPrice(), b.getPrice());
    }

    static int sortByQuantity(ShopItem a, ShopItem b) {
        return Integer.compare(a.getCount(), b.getCount());
    }
}
