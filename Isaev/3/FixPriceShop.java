
import java.util.Arrays;



public class FixPriceShop {

    String[] items = {"coffee", "tea", "chocolate", "mint", "bread", "pens", "socks", "cat's food"};
    int itemPrice = 100;
    int happyHour;


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

    String[] getItems() {
        return items;
    }

    void buyItem(String item, int hour) {
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

    public static void main(String[] args) {

        FixPriceShop shop = new FixPriceShop();
        System.out.println(shop.checkItemPrice("coffee", 14));
        String[] currentItems = shop.getItems();
        for (String i : currentItems) {
            System.out.println(i);
        }
        shop.buyItem("coffee", 10);
        String[] newCurrentItems = shop.getItems();
        for (String i : newCurrentItems) {
            System.out.println(i);
        }
    }
}
