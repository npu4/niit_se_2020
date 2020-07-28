package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ElectronicItem;
import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;

import static java.lang.String.format;

final public class ElectronicAddictedVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        if (shop.size() == 0) {
            say("Похоже в магазине нет товаров");

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
            say("Не нашел подходящий товар");
        }
    }

    private void buyItem(Collection<? extends ShopItem> shop, ShopItem item) {
        shop.remove(item);
        say(format("%s куплен по %s", item.getName(), item.getPrice()));
    }
}
