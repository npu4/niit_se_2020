package org.serieznyi.shop.fabric;

import org.serieznyi.shop.factory.AppleFactory;
import org.serieznyi.shop.item.FoodItem;
import org.serieznyi.shop.item.food.Apple;
import org.serieznyi.shop.item.food.Bread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class FoodFabric {
  private static int counter = 1;

  private final ThreadLocalRandom random = ThreadLocalRandom.current();
  private final AppleFactory appleFactory;

  public FoodFabric(AppleFactory appleFactory) {
    this.appleFactory = appleFactory;
  }

  public void fillShopWithFood(Collection<? super FoodItem> shop) {
    Collection<Apple> apples = generateApples();

    shop.addAll(apples);

    Collection<Bread> breads = generateBread();

    shop.addAll(breads);

    System.out.println(
        format(
            "В магазин добавлены яблоки: %s и хлеб общим весом: %s",
            Arrays.toString(apples.stream().map(Apple::getColor).toArray(Apple.Color[]::new)),
            breads.stream().map(Bread::getWeightInGrams).reduce(0, Integer::sum)));
  }

  private Collection<Apple> generateApples() {
    Collection<Apple> apples = new ArrayList<>();

    for (int i = 0; i < random.nextInt(2, 5); i++) {
      apples.add(appleFactory.create());
    }

    return apples;
  }

  private Collection<Bread> generateBread() {
    Collection<Bread> breads = new ArrayList<>();

    for (int i = 0; i < random.nextInt(2, 10); i++) {
      breads.add(makeBread());
    }

    return breads;
  }

  private Bread makeBread() {
    return new Bread(
        "Хлеб №" + counter++,
        random.nextInt(10, 50),
        random.nextInt(10, 40),
        random.nextInt(5, 10),
        random.nextInt(100, 400));
  }
}
