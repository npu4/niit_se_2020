package shop.visitors;

import shop.items.ShopItem;

import java.util.Collection;

public class ImJustLookingVisitor implements ShopVisitor{
    @Override
    public void visitShop(Collection<? extends ShopItem> shopItems) {
        System.out.println("------------- В магазине ImJustLookingVisitor -------------");
        for(ShopItem shopItem : shopItems){
            System.out.println(shopItem.getName() + " - " + shopItem.getPrice());
        }
    }
}
