package Shops.visitors;

import Shops.items.ShopItem;

import java.util.Collection;

public interface ShopVisitor {
    void visitShop(Collection<? extends ShopItem> shop);
}
