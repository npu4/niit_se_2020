package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;

/**
 * Просто смотрит товары и выводит их на консоль в формате Название - цена
 */
final public class ImJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        if (shop.size() == 0) {
            String message = String.format(
                    "%s: Похоже в магазине нет товаров",
                    getClass().getSimpleName()
            );

            System.out.println(message);

            return;
        }

        for (ShopItem item: shop) {
            String message = String.format(
                    "%s: Просто смотрю товар \"%s\" и похоже он стоит %s",
                    getClass().getSimpleName(),
                    item.getName(),
                    item.getPrice()
            );

            System.out.println(message);
        }
    }
}
