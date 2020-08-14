package org.serieznyi.maven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Shop {
    final private List<Comparator<ShopItem>> comparators = new ArrayList<>();

    final private List<ShopItem> items = new ArrayList<>();

    public void addItem(ShopItem shopItem)
    {
        items.add(shopItem);
    }

    public void addComparator(Comparator<ShopItem> comparator)
    {
        comparators.add(comparator);
    }

    public List<ShopItem> getSortedItems() {
        return items.stream().sorted(getAnyComparator()).collect(Collectors.toList());
    }

    private Comparator<ShopItem> getAnyComparator()
    {
        return comparators.get(ThreadLocalRandom.current().nextInt(0, comparators.size()));
    }
}
