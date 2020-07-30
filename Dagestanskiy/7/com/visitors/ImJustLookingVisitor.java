package visitors;
import products.ShopItem;

import java.util.ArrayList;

public class ImJustLookingVisitor implements ShopVisitor {
        ArrayList<? extends ShopItem> shopItems;
        String name;
        String shop;

    public ImJustLookingVisitor(ArrayList<? extends ShopItem> shopItems, String name, String shop) {
        this.shopItems = shopItems;
        this.name = name;
        this.shop = shop;
    }

    @Override
    public void visitShop() {
        System.out.println("\n"+name+" посетил магазин "+shop+" и осмотрел товары:");

        for (ShopItem shopItem : shopItems) {
            System.out.println("Название товара: " + shopItem.getProductName() +
                    ", цена: " + shopItem.getPriceProduct());

        }

    }
    @Override
    public String toString() {
        return "ImJustLookingVisitor{" +
                "shopItems=" + shopItems +
                ", name='" + name + '\'' +
                '}';
    }
}

