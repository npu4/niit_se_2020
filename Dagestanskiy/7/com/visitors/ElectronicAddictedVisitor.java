package visitors;

import products.ElectronicItem;
import products.ShopItem;

import java.util.ArrayList;

public class ElectronicAddictedVisitor implements ShopVisitor{
    ArrayList<? extends ShopItem> shopItems;
    String name;
    String shop;

    public ElectronicAddictedVisitor(ArrayList<? extends ShopItem> shopItems, String name, String shop) {
        this.shopItems = shopItems;
        this.name = name;
        this.shop = shop;
    }
    @Override
    public void visitShop() {
        System.out.println("\n"+name+" посетил магазин "+shop+" и осмотрел товары:");
        Double maxPowerConsumptions = 0d;
        int index = -1;
        for (int i = 0; i < shopItems.size(); i++) {
            System.out.println("Название товара: " + shopItems.get(i).getProductName() +
                    ", цена: " + shopItems.get(i).getPriceProduct());
            if (shopItems.get(i) instanceof ElectronicItem &&
                    ((ElectronicItem) shopItems.get(i)).getPowerConsumption()>maxPowerConsumptions){
                index = i;
                maxPowerConsumptions = ((ElectronicItem) shopItems.get(i)).getPowerConsumption();
            }

        }
        if(index>=0){
            System.out.println("Покупатель "+ name+" купил товар : "+ shopItems.get(index).getProductName()+
                    " самой большой мощностью "+((ElectronicItem) shopItems.get(index)).getPowerConsumption());
            shopItems.remove(index);
        }

    }

}
