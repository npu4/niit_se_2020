package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;

/**
 * Просто смотрит товары и выводит их на консоль в формате Название - цена
 */
final public class ImJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        for (ShopItem item: shop) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
    }
}
