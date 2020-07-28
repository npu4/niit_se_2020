package org.serieznyi.shop.visitor;

import org.serieznyi.shop.item.ElectronicItem;
import org.serieznyi.shop.item.ShopItem;

import java.util.Collection;

final public class ElectronicAddictedVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        ElectronicItem electronicWithMaxPower;

        for (ShopItem item: shop) {
            if (item instanceof ElectronicItem) {
                System.out.println(item.getName() + " - " + item.getPrice());

                int currentPower = ((ElectronicItem) item).getPower();

            }
        }
    }
}
