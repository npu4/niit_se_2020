package HappyClock;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] items1 = {"ручка", "карандаш", "ластик", "точилка", "линейка", "маркер", "тетрадь"};
        String[] items2 = {"вода", "шоколадка", "апельсин", "яблоко", "молоко", "сметана"};
        String[] items3 = {"расческа", "заколка"};

        FixPriceShop firstShop = new FixPriceShop(items1, new Random().nextInt(24));
        FixPriceShop secondShop = new FixPriceShop(items2, new Random().nextInt(24));
        FixPriceShop thirdShop = new FixPriceShop(items3, new Random().nextInt(24));

        buy(firstShop);
        buy(secondShop);
        buy(thirdShop);
    }

    private static void buy(FixPriceShop shop) {
        String[] availableItems = shop.getItems();
        String someItem = availableItems[new Random().nextInt(availableItems.length)];
        int bestHour = 0;
        for (int i = 0; i < 24; i++) {
            if (shop.checkItemPrice(someItem, i) < FixPriceShop.price) {
                bestHour = i;
            }
        }
        shop.buyItem(someItem, bestHour);
        shop.buyItem(someItem, bestHour);
    }
}