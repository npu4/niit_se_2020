package org.serieznyi;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class Main {
  private static final String[] ALLOWED_PRODUCT_NAMES = {
    "Зеленый стул",
    "Модель самолета",
    "Брелок (сломанный)",
    "Шорты",
    "Сок \"Две шестерки\"",
    "Синие шорты",
    "Миниатюрное пианино",
    "Рюкзак",
    "Не рюкзак",
    "Красный стул",
    "Красный кабриолет (модель)",
    "Лампочка Ильича",
    "Лампочка",
    "Коробка с сюрпризом",
    "Почка (мужская, 23 года)",
    "Колода карта",
    "Колода блинов",
    "Ручка от двери",
    "Крекер (1 шт, надкушенный)",
    "Фаллафель (с мясом)",
  };

  public static void main(String[] args) {
    FixPriceShop[] shops = generateShops();

    for (FixPriceShop shop : shops) {
      System.out.printf("--------------------\nЗайду-ка я в магазин \"%s\"\n", shop.getName());

      String[] shopItems = shop.getItems();

      String itemToBuy = shopItems[0];

      float lastPrice = 0;

      String waitMessage = "Сейчас %02d:00 и товар \"%s\" стоит %s у.е. Продолжаем наблюдение.\n";

      for (int hour = 0; hour < 24; hour++) {
        float price = shop.checkItemPrice(itemToBuy, hour);

        if (-1 == price) {
          System.out.printf("Хм... Я хотел купить товар \"%s\", а его больше нет в продаже\n", itemToBuy);
          break;
        }

        if (lastPrice == 0) {
          lastPrice = price;
          System.out.printf(waitMessage, hour, itemToBuy, price);
          continue;
        }

        boolean newPriceLower = price < lastPrice;
        boolean lastPriceLower = price > lastPrice;
        if (newPriceLower || lastPriceLower) {
          if (lastPriceLower) {
            System.out.printf("Сейчас %02d:00 и товар \"%s\" стоит %s у.е.\n", hour, itemToBuy, price);
            System.out.printf(
                "А вот теперь уже интересно. Похоже в %02d:00 был счастливый час и товар \"%s\" стоил %s у.е. В следующий раз приду в %02d:00 и возьму два!! \n",
                --hour, itemToBuy, lastPrice, hour);
            System.out.printf("Сейчас %02d:00 и это значит, что пора тратить денежки \n", hour);
          } else {
            System.out.printf(
                "А вот теперь уже интересно. Сейчас %02d:00 и товар \"%s\" стоит уже %s у.е. Беру! Дайте два!! \n",
                hour, itemToBuy, price);
          }

          shop.buyItem(itemToBuy, hour);
          shop.buyItem(itemToBuy, hour);
        } else {
          System.out.printf(waitMessage, hour, itemToBuy, price);
        }

        lastPrice = price;
      }
    }
  }

  static String[] generateItems() {
    int newSize = (int) (ALLOWED_PRODUCT_NAMES.length * 0.75);

    return Arrays.stream(ALLOWED_PRODUCT_NAMES)
        .sorted((String s1, String s2) -> ThreadLocalRandom.current().nextInt(-1, 1))
        .limit(newSize)
        .toArray(String[]::new);
  }

  private static FixPriceShop[] generateShops() {
    String[] items = generateItems();
    Supplier<Integer> randomHour = () -> ThreadLocalRandom.current().nextInt(0, 23);

    FixPriceShop[] shops = new FixPriceShop[3];
    int chunkSize = 3;
    for (int i = 0, shopNum = 0; shopNum < shops.length; i += chunkSize, shopNum++, chunkSize++) {
      String[] itemsChunk = Arrays.copyOfRange(items, i, Math.min(items.length, i + chunkSize));

      shops[shopNum] = new FixPriceShop(itemsChunk, randomHour.get());
    }

    return shops;
  }
}
