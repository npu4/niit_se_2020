package org.serieznyi;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public final class FixPriceShop {
  public static final int HAPPY_HOUR_DISCOUNT_PERCENT_SIZE = 50;

  public static final int GENERAL_ITEM_PRICE;

  private static String[] ALLOWED_NAMES = {
    "Три короля",
    "Одиннадцать стульев",
    "Белый олень",
    "Три корыта",
    "Сова и шляпа",
    "Тарарам",
    "Князь",
    "Куб",
  };

  static {
    GENERAL_ITEM_PRICE = ThreadLocalRandom.current().nextInt(1, 200);
  }

  private final int happyHour;
  private final String name;
  private String[] items;

  FixPriceShop(String[] items, int happyHour) {
    items = Arrays.stream(items).filter(Objects::nonNull).toArray(String[]::new);
    if (items.length == 0) {
      throw new IllegalArgumentException("Кажется вы потеряли мои товары");
    }
    this.items = items;

    this.happyHour = happyHour;

    this.name = generateName();
  }

  private static String generateName() {
    int index = ThreadLocalRandom.current().nextInt(0, ALLOWED_NAMES.length);

    String name = ALLOWED_NAMES[index];

    ALLOWED_NAMES =
        Arrays.stream(ALLOWED_NAMES).filter(s -> !s.equals(name)).toArray(String[]::new);

    return name;
  }

  public float checkItemPrice(String item, int hour) {
    if (!isItemExists(item)) {
      return -1;
    }

    return calculatePriceForHour(hour);
  }

  public void buyItem(String item, int hour) {
    if (!isItemExists(item)) {
      System.out.printf("Товар \"%s\" не обнаружен\n", item);
      return;
    }

    float price = calculatePriceForHour(hour);

    System.out.printf("Товар \"%s\" продан по цене %s\n", item, price);

    removeItem(item);
  }

  private void removeItem(String item) {
    items = Arrays.stream(items).filter(s -> !s.equals(item)).toArray(String[]::new);
  }

  private boolean isItemExists(String item) {
    for (String p : items) {
      if (p.equals(item)) {
        return true;
      }
    }

    return false;
  }

  private float calculatePriceForHour(int hour) {
    if (hour == happyHour) {
      return (float) GENERAL_ITEM_PRICE * HAPPY_HOUR_DISCOUNT_PERCENT_SIZE / 100;
    }

    return GENERAL_ITEM_PRICE;
  }

  public String[] getItems() {
    return items;
  }

  public String getName() {
    return name;
  }
}
