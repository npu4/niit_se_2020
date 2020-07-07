public class Buy {


    public static void main(String[] args) {

        String[] shop1Product={"Кола", "Пицца", "Тапочек"};
        String[] shop2Product={"Ракетка", "Носки", "Горшок", "Герань"};
        String[] shop3Product={"Кастрюля", "Ложка", "Тарелка", "Кот"};

        FixPriceShop  shop1=new FixPriceShop(shop1Product);
        FixPriceShop  shop2=new FixPriceShop(shop2Product);
        FixPriceShop  shop3=new FixPriceShop(shop3Product);


        shop1.getItems();
        System.out.println("Первый магазин\n");
        shop2.getItems();
        System.out.println("Второй магазин\n");
        shop3.getItems();
        System.out.println("Третий магазин\n");

        System.out.println("Обычная цена на товары " + shop1.price);

        shop3.buyItem("Кот", shop3.returnLuckHour());
        shop3.buyItem("Кот", shop3.returnLuckHour());
        shop3.getItems();


    }









}
