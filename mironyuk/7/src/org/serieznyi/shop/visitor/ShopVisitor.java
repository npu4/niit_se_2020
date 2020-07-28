package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;

public interface ShopVisitor {
    public void visitShop(Collection<? extends ShopItem> shop);
}
