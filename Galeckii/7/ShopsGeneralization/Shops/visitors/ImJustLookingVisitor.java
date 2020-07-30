package Shops.visitors;

import Shops.items.ShopItem;

import java.util.Collection;

public class ImJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        shop.forEach(shopItem -> System.out.printf("%s - %d\n", shopItem.getName(), shopItem.getPrice()));
    }
}
