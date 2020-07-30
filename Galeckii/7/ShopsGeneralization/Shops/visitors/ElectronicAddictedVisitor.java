package Shops.visitors;

import Shops.items.ElectronicItem;
import Shops.items.ShopItem;

import java.util.Collection;

public class ElectronicAddictedVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        lookAtItems(shop);
        buy(shop);
    }

    private void lookAtItems(Collection<? extends ShopItem> shop) {
        shop.forEach(shopItem -> {
            if (shopItem instanceof ElectronicItem) {
                System.out.println(shopItem.getName());
            }
        });
    }

    private void buy(Collection<? extends ShopItem> shop) {
        int maxPower = 0;
        ShopItem target = null;
        for (ShopItem item : shop) {
            if (item instanceof ElectronicItem && ((ElectronicItem) item).getPowerConsumption() > maxPower) {
                target = item;
                maxPower=((ElectronicItem) item).getPowerConsumption();
            }
        }
        if (target != null) {
            System.out.printf("%s куплен по %d\n", target.getName(), target.getPrice());
        }
        shop.remove(target);
    }
}
