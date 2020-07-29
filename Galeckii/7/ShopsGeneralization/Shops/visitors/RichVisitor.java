package Shops.visitors;

import Shops.items.ShopItem;

import java.util.ArrayList;
import java.util.Collection;

public class RichVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        int count = 0;
        ArrayList<ShopItem> toDelete = new ArrayList<>();
        for (ShopItem item : shop) {
            if (count % 2 == 0) {
                System.out.println(item.getName() + " куплен");
                toDelete.add(item);
            }
            count++;
        }
        shop.removeAll(toDelete);
    }
}
