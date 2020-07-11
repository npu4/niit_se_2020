import java.util.Random;

public class FixPriceShop {
    String items[];
    int fixPrice;
    int luckyHour;

    public FixPriceShop(String[] productsForShop, int price) {

        this.items = productsForShop;
        this.fixPrice = price;
        this.luckyHour = setLuckyHour();

    }

    int setLuckyHour() {
        Random random = new Random();
        return random.nextInt(24);
    }
    public int getLuckyHour(){
        return this.luckyHour;
    }

    public int getFixPrice() {
        return fixPrice;
    }

    public String[] getItems() {
        return items;
    }
    public int checkItemPrice(String item, int hour) {
        for (String i: items
             ) { if ( i.equals(item)){
                 if( hour == luckyHour){ return fixPrice/2;
                 } else { return fixPrice;}
        }

        }
        return -1;
    }
    public void buyItem(String item, int hour){
        int sellingPrice = checkItemPrice(item, hour);
        if (sellingPrice == -1) {
            System.out.println("Товар "+ item + " не обнаружен.");
        } else {
            System.out.println("Товар "+ item + " продан по цене "+sellingPrice);
            int a = items.length;
            String[] tempItems = new String[a-1];
            int j =0;
            for (int i=0; i < a; i++){
                if(!items[i].equals(item)){
                    tempItems[j] = items[i];
                    j++;
                }
            }

            this.items = tempItems;
        }
    }


}