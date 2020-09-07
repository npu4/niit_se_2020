package HappyClock;

import java.util.Random;

public class FixPriceShop {
    String[] items;
    static int price = new Random().nextInt(1000);
    int happyHour;

    FixPriceShop(String[] shopItems, int hour){
        items = shopItems;
        happyHour = hour;
    }

    int checkItemPrice(String item, int hour){
        for (String i : items){
            if(item.equals(i)){
                if(hour == happyHour){
                    return price/2;
                }
                else{
                    return price;
                }
            }
        }
        return -1;
    }

    String[] getItems(){
        int numNulls = 0;
        for (String i : items){
            if (i == null) {
                numNulls++;
            }
        }
        String[] availableItems = new String[items.length-numNulls];
        int k = 0;
        for (String i : items){
            if(i != null){
                availableItems[k++] = i;
            }
        }
        return availableItems;
    }

    void buyItem(String item, int hour){
        if(checkItemPrice(item,hour) == -1){
            System.out.println("Товар " + item + " не обнаружен");
        }
        else{
            System.out.println("Товар " + item + " продан по цене " + checkItemPrice(item,hour));
            for (int i = 0; i < items.length; i++){
                if(item.equals(items[i])){
                    items[i] = null;
                    break;
                }
            }
        }
    }
}
