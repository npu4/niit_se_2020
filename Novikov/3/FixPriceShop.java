class FixPriceShop {

 //   private
 public
    String[] items;
    int luckHour;
    static int price;





    FixPriceShop(String[] itemsForThisShop ){
        items=itemsForThisShop;
        price=(int)(Math.random()*100);
        luckHour=setLuckHours();
    }

    int setLuckHours(){
        luckHour=(int)(Math.random()*23);
        return luckHour;
    }

    int delItems(String item){
        String[] perem=new String[items.length-1];
        for (int i=0; i<items.length; i++){
            if(items[i].equals(item)){
                for(;i<items.length-1;i++)
                    items[i]=items[i+1];
                for(i=0; i<items.length-1;i++){
                    perem[i]= items[i];
                }
                items=perem;
                return 0;
            }

        }
        return -1;
    }

    int returnLuckHour(){
        return luckHour;
    }

    int checkItemPrice(String item, int hour){
        int finalPrice=-1;
        for(String firstItem:items){
            if((firstItem.equals(item))&&(hour!=luckHour)){
                finalPrice=price;
                break;
            }
            if((firstItem.equals(item))&&(hour==luckHour)){
                finalPrice=price/2;
                break;
            }
        }
        return finalPrice;
    }

//Нет необходимости возвращать массив. Эффективнее его напечатать.
    void getItems(){
        for(String firstItem:items){
            System.out.println(firstItem);
        }
    }

    void buyItem(String item, int hour){
        int finalPrice=checkItemPrice(item,hour);
        if(finalPrice==-1)
            System.out.println("Товар не обнаружен");
        else{
            System.out.println("Товар "+ item +" продан по цене "+finalPrice);
            delItems(item);
        }
    }




}

