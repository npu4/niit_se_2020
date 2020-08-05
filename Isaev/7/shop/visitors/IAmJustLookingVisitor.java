package shop.visitors;

import shop.items.ShopItem;

import java.util.Collection;

public class IAmJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> list) {
        for (ShopItem item : list) {
            System.out.println(item.getItemName() + " - " + item.getSalePrice());

        }
    }
}
