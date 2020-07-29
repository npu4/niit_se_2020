package Shops.factories;

import Shops.items.Apple;
import Shops.items.ElectronicItem;
import Shops.items.Refrigerator;
import Shops.items.TV;

import java.util.Collection;
import java.util.Random;

public class ElectronicFabric {
    public static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> shop) {
        StringBuilder electronicList = new StringBuilder();

        for (int i = 0; i < new Random().nextInt(3) + 2; i++) {
            shop.add(addElectronic(electronicList));
        }

        System.out.println("В магазин добавлена электроника: " +
                electronicList
                        .deleteCharAt(electronicList.length() - 1)
                        .deleteCharAt(electronicList.length() - 1)
                        .toString());
    }

    private static ElectronicItem addElectronic(StringBuilder electronicList) {
        switch (new Random().nextInt(3)) {
            case (0):
                electronicList.append("Frost, ");
                return new Refrigerator("Frost", 3000, 20, 10);
            case (1):
                electronicList.append("Borovinka, ");
                return new TV("Tamsung", 30000, 15, 70);
            case (2):
                electronicList.append("Sharopay, ");
                return new TV("MG", 45000, 40, 110);
            default:
                return null;
        }


    }
}
