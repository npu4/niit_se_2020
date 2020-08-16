package org.apache.commons;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Shop {
    List<ShopItem> items = new ArrayList<>();
    List<Comparator<ShopItem>> comparators = new ArrayList<>();

    public Shop() {
    }

    void addItem(ShopItem item) {
        items.add(item);
    }

    void addComparator(Comparator<ShopItem> comparator) {
        comparators.add(comparator);
    }

    public List<ShopItem> getItems() {
        return items;
    }

    public Comparator<ShopItem> getRandomComparator() {
        return comparators.get(new Random().nextInt(comparators.size()));
    }

    public List<ShopItem> sortItem() {
        return items.stream().sorted(getRandomComparator()).collect(Collectors.toList());
    }
}
