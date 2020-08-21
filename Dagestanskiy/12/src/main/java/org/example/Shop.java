package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//import static jdk.vm.ci.sparc.SPARC.o1;
//import static jdk.vm.ci.sparc.SPARC.o2;

public class Shop {
    List<ShopItem> itemList = new ArrayList<>();
    List<Comparator<ShopItem>> comparators = new ArrayList<>();

    public Shop() {
        itemList.add(new ShopItem("Бакалея",52.2,"Рис",100,RandomStringUtils.randomAlphanumeric(25) ));
        itemList.add(new ShopItem("Бакалея",32.4,"Сахар",500,RandomStringUtils.randomAlphanumeric(25) ));
        itemList.add(new ShopItem("Бакалея",80.2,"Пшено",400,RandomStringUtils.randomAlphanumeric(25) ));
        itemList.add(new ShopItem("Бакалея",40.0,"Горох",255,RandomStringUtils.randomAlphanumeric(25) ));
        itemList.add(new ShopItem("Мебель",20000.0,"Диван",10,RandomStringUtils.randomAlphanumeric(25) ));
        itemList.add(new ShopItem("Мебель",15000.0,"Шкаф",15,RandomStringUtils.randomAlphanumeric(25) ));
        itemList.add(new ShopItem("Мебель",1000.0,"Стул",20,RandomStringUtils.randomAlphanumeric(25) ));
        itemList.add(new ShopItem("Посуда",1500.0,"Кастрюля",30,RandomStringUtils.randomAlphanumeric(25) ));
        itemList.add(new ShopItem("Посуда",1100.0,"Сковорода",25,RandomStringUtils.randomAlphanumeric(25) ));
        itemList.add(new ShopItem("Посуда",150.0,"Тарелка",50,RandomStringUtils.randomAlphanumeric(25) ));
        comparators.add(ItemSorters::sortByCategory);
        comparators.add(ItemSorters::sortByTitle);
        comparators.add(ItemSorters::sortByPrice);
        comparators.add(ItemSorters::sortByQuantity);
    }
    public void printShop() {
        String[] nameFieldShopItem = new String[]{"Категория:","Наименование:","Цена:","Остаток:"};
        int count = rnd(0,3);
        itemList.sort(comparators.get(count));
        System.out.println("    Список товаров отсортирован по полю - "+nameFieldShopItem[count]);
        System.out.printf("%10s %10s %13s %10s %10s\n","ID:",nameFieldShopItem[0],nameFieldShopItem[1],
                nameFieldShopItem[2],nameFieldShopItem[3]);
        for (ShopItem shopItem:itemList) {
            System.out.printf("%10s %10s %13s %10.2f %10d\n", StringUtils.abbreviate(shopItem.getID(), 10),
                   StringUtils.abbreviate(shopItem.getCategory(), 10),
                   StringUtils.abbreviate(shopItem.getTitle(), 13),
                    shopItem.getPrice(),
                    shopItem.getQuantity());
        }

    }

    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
