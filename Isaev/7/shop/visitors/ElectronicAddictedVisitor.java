package shop.visitors;

import shop.items.ElectronicItem;
import shop.items.ShopItem;

import java.util.Collection;

public class ElectronicAddictedVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> list) {
        int powerConsumption = 0;
        ShopItem itemToBuy = null;
        for (ShopItem item : list) {
            if (item instanceof ElectronicItem) {
                item.toString();
                if (((ElectronicItem) item).getPowerConsumption() > powerConsumption) {
                    powerConsumption = ((ElectronicItem) item).getPowerConsumption();
                    itemToBuy = item;
                }

            }
        }

        System.out.println(itemToBuy.getItemName() + " куплен по цене:" + itemToBuy.getSalePrice());
        list.remove(itemToBuy);
    }
}
