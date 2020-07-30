package visitors;

import products.ShopItem;

import java.util.ArrayList;

public class RichVisitor implements ShopVisitor {
    ArrayList<?extends  ShopItem> shopItems;
    String name;
    String shop;

    public RichVisitor(ArrayList<?extends  ShopItem> shopItems, String name, String shop) {
        this.shopItems = shopItems;
        this.name = name;
        this.shop = shop;
    }

    @Override
    public void visitShop() {
        System.out.println("\n" + name + " посетил магазин " + shop + " и купил товары:");
        ArrayList<ShopItem> buyShopItems = new ArrayList<>();
//        ArrayList<ShopItem> notBuyShopItems = new ArrayList<>();
        for (int i = 0; i < shopItems.size(); i++) {
            if (i % 2 > 0) {
                buyShopItems.add(shopItems.get(i));
            }
        }
        for (ShopItem buyShopItem : buyShopItems) {
            System.out.println("Название товара: " + buyShopItem.getProductName() +
                    ", цена: " + buyShopItem.getPriceProduct());
            for (int j = 0; j < shopItems.size(); j++) {
                if (shopItems.get(j).getProductName().equals(buyShopItem.getProductName())) {
                    shopItems.remove(j);
                    break;
                }

            }
        }

    }
}