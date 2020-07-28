package org.serieznyi.shop.fabric;

import org.serieznyi.shop.item.ElectronicItem;
import org.serieznyi.shop.item.ShopItem;
import org.serieznyi.shop.item.electronic.Refrigerator;
import org.serieznyi.shop.item.electronic.TV;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class ElectronicFabric {
  private static int counter = 1;
  private final ThreadLocalRandom random = ThreadLocalRandom.current();

  public void fillShopWithElectronicGoods(Collection<? super ElectronicItem> shop) {
    Collection<ElectronicItem> items = makeItems();

    shop.addAll(items);

    System.out.println(
        String.format(
            "В магазин добавлена электроника: %s",
            items.stream().map(ShopItem::getName).reduce("", (a, b) -> a + b + ", ")));
  }

  private Collection<ElectronicItem> makeItems() {
    Collection<ElectronicItem> items = new ArrayList<>();
    List<Supplier<ElectronicItem>> generators = new ArrayList<>();
    generators.add(this::makeTv);
    generators.add(this::makeRefrigerator);

    for (int i = 0; i < random.nextInt(2, 10); i++) {
      items.add(generators.get(random.nextInt(0, generators.size())).get());
    }

    return items;
  }

  private TV makeTv() {
    return new TV(
        "Телевизор №" + counter++,
        random.nextInt(500, 1000),
        random.nextInt(300, 500),
        random.nextInt(1, 100));
  }

  private Refrigerator makeRefrigerator() {
    return new Refrigerator(
        "Холодильник №" + counter++,
        random.nextInt(500, 1000),
        random.nextInt(300, 500),
        random.nextInt(1, 5));
  }
}
