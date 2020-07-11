package shop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FixPriceShop shop1 = new FixPriceShop(new LinkedList<>(Arrays.asList("apple", "pear", "melon")));
        String item1 = shop1.getItems().get(new Random().nextInt(shop1.getItems().size()));
        shop1.buyItem(item1, shop1.getLUCKY_HOUR());
        shop1.buyItem(item1, shop1.getLUCKY_HOUR());

        FixPriceShop shop2 = new FixPriceShop(new LinkedList<>(Arrays.asList("phone", "headphone", "microphone")));
        String item2 = shop2.getItems().get(new Random().nextInt(shop2.getItems().size()));
        shop2.buyItem(item2, shop2.getLUCKY_HOUR());
        shop2.buyItem(item2, shop2.getLUCKY_HOUR());

        FixPriceShop shop3 = new FixPriceShop(new LinkedList<>(Arrays.asList("yacht", "helicopter", "car")));
        String item3 = shop3.getItems().get(new Random().nextInt(shop3.getItems().size()));
        shop3.buyItem(item3, shop3.getLUCKY_HOUR());
        shop3.buyItem(item3, shop3.getLUCKY_HOUR());
    }
}
