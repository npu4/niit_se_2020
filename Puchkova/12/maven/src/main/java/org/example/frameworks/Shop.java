package org.example.frameworks;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Shop {
    Collection<ShopItem> shopItems;

    List<Comparator<ShopItem>> comparatorList;

    {
        comparatorList = new ArrayList<>();
        comparatorList.add(ItemSorters::sortByCategory);
        comparatorList.add(ItemSorters::sortByTitle);
        comparatorList.add(ItemSorters::sortByPrice);
        comparatorList.add(ItemSorters::sortByQuantity);
    }

    public Shop(Collection<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    public void randomSort() {
        System.out.printf("%13s%13s%13s%13s%13s%n", "ID", "Категория", "Наименование", "Цена", "Остаток");
        int randomComparator = new Random().nextInt(comparatorList.size());
        Comparator<ShopItem> comparator = comparatorList.get(randomComparator);
        shopItems.stream()
                .sorted(comparator)
                .forEach(shopItem -> System.out.printf("%13s%13s%13s%13s%13s%n",
                        StringUtils.abbreviate(shopItem.getId(), 10),
                        StringUtils.abbreviate(shopItem.getCategory(), 10),
                        StringUtils.abbreviate(shopItem.getTitle(), 10),
                        StringUtils.abbreviate(Double.toString(shopItem.getPrice()), 10),
                        StringUtils.abbreviate(Integer.toString(shopItem.getQuantity()), 10)));
    }
}
