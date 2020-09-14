package shop.visitors;

import shop.items.ElectronicItem;
import shop.items.ShopItem;

import java.util.Collection;

public class ElectronicAddictedVisitor implements ShopVisitor{
    @Override
    public void visitShop(Collection<? extends ShopItem> shopItems) {
        System.out.println("------------- В магазине ElectronicAddictedVisitor --------");
        Integer biggestPowerConsumption = 0;
        ShopItem purchasedShopItem = new ElectronicItem();
        for(ShopItem shopItem : shopItems){
            if(shopItem instanceof ElectronicItem){
                System.out.println(shopItem.getName() + " - " + shopItem.getPrice());
                if(((ElectronicItem) shopItem).getPowerConsumption() > biggestPowerConsumption){
                    biggestPowerConsumption = ((ElectronicItem) shopItem).getPowerConsumption();
                    purchasedShopItem = shopItem;
                }
            }
        }
        if(! (biggestPowerConsumption == 0)){
            shopItems.remove(purchasedShopItem);
            System.out.println(purchasedShopItem.getName() + " куплен по " + purchasedShopItem.getPrice());
        }
        else{
            System.out.println("Покупатель не нашел электроники в этом магазине");
        }
    }
}
