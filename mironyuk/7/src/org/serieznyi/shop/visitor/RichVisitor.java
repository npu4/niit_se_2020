package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;
import java.util.Iterator;

import static java.lang.String.format;

final public class RichVisitor implements ShopVisitor {
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

        int i = 1;
        Iterator<? extends ShopItem> iterator = shop.iterator();
        while (iterator.hasNext()) {
            ShopItem item = iterator.next();
            if (i % 2 == 0) {
                String message = format("%s: %s куплен по %s", getClass().getSimpleName(), item.getName(), item.getPrice());
                System.out.println(message);
                iterator.remove();
            }

            i++;
        }
    }
}
