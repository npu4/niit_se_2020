package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ElectronicItem;
import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;

import static java.lang.String.format;

final public class ElectronicAddictedVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        say("Как же я люблю электронику. Может тут что-то есть!?");

        if (shop.size() == 0) {
            say("Похоже в магазине нет товаров");

            return;
        }

        ElectronicItem electronicWithMaxPower = null;

        for (ShopItem item: shop) {
            if (item instanceof ElectronicItem) {
                ElectronicItem currentItem = (ElectronicItem) item;

                say(format("Просто смотрю товар \"%s\" и похоже его мощность %s", currentItem.getName(), currentItem.getPower()));


                if (null == electronicWithMaxPower || electronicWithMaxPower.getPower() < currentItem.getPower()) {
                    electronicWithMaxPower = currentItem;
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
