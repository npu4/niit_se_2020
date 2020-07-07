import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


public class FixPriceShop {

    String[] items = {"coffee","tea","chocolate","mint","bread","pens","socks","cat's food"};
    int itemPrice = 100;
    int happyHour;


    public FixPriceShop() {
        happyHour = 14;
    }

    public FixPriceShop(int happyHour) {
        this.happyHour = happyHour;
    }

    int checkItemPrice(String item, int hour){
       int findItems = Arrays.asList(items).indexOf(item);
       if (findItems == -1){
           return -1;
       } else if (hour == happyHour){
           return  itemPrice / 2;
       } else {
           return itemPrice;
       }
    }

    String[] getItems(){
        return items;
    }

    void buyItem(String item,int hour) {
        System.out.println("Goods " + item + " sold at a price " + checkItemPrice(item, hour));
        int indexOfItem = Arrays.asList(items).indexOf(item);
        items[indexOfItem] = "bought";
        String[] newItems = new String[items.length - 1];
        System.arraycopy(items,0,newItems,0,);
    }

    public static void main(String[] args) {


        FixPriceShop shop = new FixPriceShop();
        System.out.println(shop.checkItemPrice("coffee",14));
        String[] currentItems = shop.getItems();
        for (String i : currentItems){
            System.out.println(i);
        }
        shop.buyItem("coffee",10);
        for (String i : currentItems){
            System.out.println(i);
        }



    }

}
