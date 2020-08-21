package org.example;

public class ItemSorters {

    public static int sortByCategory(ShopItem o1,ShopItem o2){
        return o1.getCategory().compareTo(o2.getCategory());
    }
    public static int sortByTitle(ShopItem o1, ShopItem o2){
        return o1.getTitle().compareTo(o2.getTitle());
    }
    public static int sortByPrice(ShopItem o1,ShopItem o2){
        return  Double.compare(o1.getPrice(),o2.getPrice());
    }
    public static int sortByQuantity(ShopItem o1,ShopItem o2){
        return Integer.compare(o1.getQuantity(), o2.getQuantity());
    }
}
