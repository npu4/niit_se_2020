package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;

final public class RichVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        int i = 1;
        for (ShopItem item: shop) {
            if (i % 2 == 0) {
                System.out.println(String.format("%s куплен по %s", item.getName(), item.getPrice()));
            }

            i++;
        }
    }
}
