
import java.util.Arrays;


public class FixPriceShop {

    public static String[] defaultItems = {"coffee", "tea", "chocolate", "mint", "bread", "pens", "socks", "cat's food"};
    String[] items;
    public static final int ITEM_PRICE = 100;
    public static final int DEFAULT_HAPPY_HOUR = 14;
    int happyHour;

    public FixPriceShop(String[] items) {
        this(items, DEFAULT_HAPPY_HOUR);
    }

    public FixPriceShop() {
        this(defaultItems, DEFAULT_HAPPY_HOUR);
    }

    public FixPriceShop(int happyHour) {
        this(defaultItems, happyHour);
    }

    public FixPriceShop(String[] items, int happyHour) {
        this.items = items;
        this.happyHour = happyHour;
    }

    boolean productAvailability(String[] items, String item) {
        return Arrays.asList(items).contains(item);
    }

    int checkItemPrice(String item, int hour) {
        if (!productAvailability(items, item)) {
            return -1;
        } else if (hour == happyHour) {
            return ITEM_PRICE / 2;
        } else {
            return ITEM_PRICE;
        }

    }

    void bestBuyTime(String item, int hour) {
        if (productAvailability(items, item)) {
            if (hour == happyHour) {
                System.out.println("Now is the best time to buy. Prise is " + checkItemPrice(item, hour) + " rubles");
            } else {
                System.out.println("Better time to buy this item is " + happyHour + " hour. Now it's prise " + checkItemPrice(item, hour) + " rubles");
            }
        } else {
            System.out.println("Item " + item + " is out of stock");
        }
    }

    String[] getItems() {
        return items;
    }

    void buyItem(String item, int hour) {
        if (checkItemPrice(item, hour) == -1) {
            System.out.println("Item " + item + " is out of stock");
        } else {
            System.out.println("Goods " + item + " sold at a price " + checkItemPrice(item, hour));
            String[] remainingItem = new String[items.length - 1];
            for (int i = 0; i < items.length; i++) {
                if (items[i].equals(item)) {
                    for (; i < items.length - 1; i++) {
                        items[i] = items[i + 1];
                    }
                    for (i = 0; i < items.length - 1; i++) {
                        remainingItem[i] = items[i];
                    }
                    items = remainingItem;
                }
            }
        }
    }

    public static void main(String[] args) {

        FixPriceShop shop = new FixPriceShop();
        System.out.println(shop.checkItemPrice("coffee", 14));
        String[] currentItems = shop.getItems();
        shop.buyItem("coffee", 10);
        String[] newCurrentItems = shop.getItems();
    }
}
