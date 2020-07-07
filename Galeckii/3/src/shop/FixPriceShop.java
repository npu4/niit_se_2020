package shop;

import java.util.List;
import java.util.Random;

public class FixPriceShop {
    List<String> items;
    final int PRICE = 30;
    final int LUCKY_HOUR;

    public FixPriceShop(List<String> items) {
        this.items = items;
        LUCKY_HOUR = new Random().nextInt(24);
    }

    public int checkItemPrice(String item, int hour) {
        if (!items.contains(item)) return -1;
        return hour == LUCKY_HOUR ? PRICE / 2 : PRICE;
    }

    public void buyItem(String item, int hour) {
        if (items.contains(item)) {
            System.out.println("товар " + item + " продан по цене " + checkItemPrice(item, hour));
            items.remove(item);
        } else {
            System.out.println("товар " + item + " не обнаружен");
        }
    }

    public List<String> getItems() {
        return items;
    }

    public int getLUCKY_HOUR() {
        return LUCKY_HOUR;
    }
}
