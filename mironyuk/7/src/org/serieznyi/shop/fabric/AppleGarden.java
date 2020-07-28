package org.serieznyi.shop.fabric;

import org.serieznyi.shop.factory.AppleFactory;
import org.serieznyi.shop.item.food.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class AppleGarden {
  private final AppleFactory appleFactory;
  private final ThreadLocalRandom random = ThreadLocalRandom.current();

  public AppleGarden(AppleFactory appleFactory) {
    this.appleFactory = appleFactory;
  }

  public void fillShopWithApples(Collection<? super Apple> shop) {
    Collection<Apple> apples = generateApples();

    shop.addAll(apples);

    System.out.println(
        format(
            "В магазин добавлены яблоки: %s",
            Arrays.toString(apples.stream().map(Apple::getColor).toArray(Apple.Color[]::new))));
  }

  private Collection<Apple> generateApples() {
    Collection<Apple> apples = new ArrayList<>();

    for (int i = 0; i < random.nextInt(2, 10); i++) {
      apples.add(this.appleFactory.create());
    }

    return apples;
  }
}
