package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ElectronicItem;
import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;

import static java.lang.String.format;

final public class ElectronicAddictedVisitor implements ShopVisitor {
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

        ElectronicItem electronicWithMaxPower = null;

        for (ShopItem item: shop) {
            if (item instanceof ElectronicItem) {
                System.out.println(item.getName() + " - " + item.getPrice());

                int currentPower = ((ElectronicItem) item).getPower();

                if (null == electronicWithMaxPower || electronicWithMaxPower.getPower() < currentPower) {
                    electronicWithMaxPower = (ElectronicItem) item;
                }
            }
        }

        if (null != electronicWithMaxPower) {
            buyItem(shop, electronicWithMaxPower);
        } else {
            System.out.println(getClass().getSimpleName() + ": Не нашел подходящий товар");
        }
    }

    private void buyItem(Collection<? extends ShopItem> shop, ShopItem item) {
        shop.remove(item);
        System.out.println(String.format("%s: %s куплен по %s", getClass().getSimpleName(), item.getName(), item.getPrice()));
    }
}
