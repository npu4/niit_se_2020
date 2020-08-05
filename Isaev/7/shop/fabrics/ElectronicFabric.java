package shop.fabrics;

import shop.items.ElectronicItem;
import shop.products.Refrigerator;
import shop.products.TV;

import java.util.Collection;
import java.util.Random;

public class ElectronicFabric {

    public void fillShopWithElectronicGoods(Collection<? super ElectronicItem> list, int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            list.add(getRandomItem());
        }
        System.out.println("В магазин добавлена электроника - " + list.toString());
    }

    ElectronicItem getRandomItem() {
        int random = new Random().nextInt(2);
        switch (random) {
            case 0:
                return new TV();
            case 1:
                return new Refrigerator();
        }
        return null;
    }
}
