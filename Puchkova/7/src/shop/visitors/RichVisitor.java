package shop.visitors;

import shop.items.ShopItem;

import java.util.Collection;
import java.util.Iterator;

public class RichVisitor implements ShopVisitor{
    @Override
    public void visitShop(Collection<? extends ShopItem> shopItems) {
        System.out.println("------------- В магазине RichVisitor ----------------------");
        Iterator iteratorForShopItems = shopItems.iterator();
        ShopItem purchasedItem;
        while(iteratorForShopItems.hasNext()){
            iteratorForShopItems.next(); // Товар, который Visitor не покупает
            if(iteratorForShopItems.hasNext()){
                purchasedItem = (ShopItem) iteratorForShopItems.next();
                iteratorForShopItems.remove();
                System.out.println(purchasedItem.getName() + " куплен по " + purchasedItem.getPrice());
            }
        }
    }
}
