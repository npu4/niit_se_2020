package shop.visitors;

import shop.items.ShopItem;

import java.util.Collection;

public class RichVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> list) {
        for (ShopItem item : list) {
            System.out.println(item.getItemName() + " куплен по цене:" + item.getSalePrice());
        }
        list.removeAll(list);
    }
}
