package org.serieznyi.shop.factory;

import org.serieznyi.shop.item.food.Apple;

import java.util.concurrent.ThreadLocalRandom;

public class AppleFactory implements ItemFactory {
  private final ThreadLocalRandom random = ThreadLocalRandom.current();
  private int counter = 1;

  public Apple create() {
    return new Apple(
        "Яблоко №" + counter++,
        random.nextInt(10, 50),
        random.nextInt(10, 40),
        random.nextInt(5, 10),
        nextAppleColor());
  }

  private Apple.Color nextAppleColor() {
    Apple.Color[] colors = Apple.Color.values();

    return colors[random.nextInt(0, colors.length)];
  }
}
