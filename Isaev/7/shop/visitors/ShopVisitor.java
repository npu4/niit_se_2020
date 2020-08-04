package shop.visitors;

import shop.items.ShopItem;

import java.util.Collection;

public interface ShopVisitor {

    void visitShop(Collection<? extends ShopItem> list);

}
