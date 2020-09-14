package shop.factories;

import shop.items.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ElectronicFabric {
    static final int MAX_NUM_OF_MAKING_ITEMS = 5;

    public static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> shopItems){
        Collection<ElectronicItem> electronicItems = makeElectronicItems();
        shopItems.addAll(electronicItems);
        System.out.println("В магазин добавлена электроника:");
        for (ElectronicItem electronicItem : electronicItems) {
            System.out.println(electronicItem.getName());
        }
        System.out.println();
    }

    static Collection<ElectronicItem> makeElectronicItems(){
        Collection<ElectronicItem> electronicItems = new ArrayList<>();
        electronicItems.addAll(makeTVs());
        electronicItems.addAll(makeRefrigerators());
        return electronicItems;
    }


    static Collection<TV> makeTVs(){
        int numOfTVs = new Random().nextInt(MAX_NUM_OF_MAKING_ITEMS) + 1;
        Collection<TV> tvs = new ArrayList<>();
        for (int i = 0; i < numOfTVs; i++) {
            tvs.add(new TV(new Random().nextInt(5000) + 2000, new Random().nextInt(101) + 100, new Random().nextInt(100) + 1));
        }
        return tvs;
    }

    static Collection<Refrigerator> makeRefrigerators(){
        int numOfRefrigerators = new Random().nextInt(MAX_NUM_OF_MAKING_ITEMS) + 1;
        Collection<Refrigerator> refrigerators = new ArrayList<>();
        for (int i = 0; i < numOfRefrigerators; i++) {
            refrigerators.add(new Refrigerator(new Random().nextInt(5000) + 2000, new Random().nextInt(101) + 100, new Random().nextInt(100) + 1));
        }
        return refrigerators;
    }
}
