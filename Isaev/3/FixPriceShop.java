
import java.util.Arrays;


public class FixPriceShop {

    String[] items = {"coffee", "tea", "chocolate", "mint", "bread", "pens", "socks", "cat's food"};
    int itemPrice = 100;
    int happyHour;

    public FixPriceShop(String[] items, int happyHour) {
        this.items = items;
        this.happyHour = happyHour;
    }

    public FixPriceShop(String[] items) {
        this.items = items;
        happyHour = 14;
    }

    public FixPriceShop() {
        happyHour = 14;
    }

    public FixPriceShop(int happyHour) {
        this.happyHour = happyHour;
    }

    int checkItemPrice(String item, int hour) {
        int findItems = Arrays.asList(items).indexOf(item);
        if (findItems == -1) {
            return -1;
        } else if (hour == happyHour) {
            return itemPrice / 2;
        } else {
            return itemPrice;
        }

    }

    void bestBuyTime(String item, int hour) {
        if (hour == happyHour) {
            System.out.println("Now is the best time to buy. Prise is " + checkItemPrice(item, hour) + " rubles");
        } else {
            System.out.println("Better time to buy this item is " + happyHour + " hour. Now it's prise " + checkItemPrice(item, hour) + " rubles");
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
                if (items[i] == item) {
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
