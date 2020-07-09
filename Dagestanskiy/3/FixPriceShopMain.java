public class FixPriceShopMain {
    public static void main(String[] args) {
        String[] productsForShop1 = {"Сахар","Рис","Пшено","Гречка","Макароны"};
        String[] productsForShop2 = {"Ластик","Ручка","Карандаш","Линейка","Фламастер"};
        String[] productsForShop3 = {"Отвертка","Сверло","Ножницы","Стержень","Уголок"};
        final int FIX_PRICE = 49;

        FixPriceShop s1 = new FixPriceShop(productsForShop1, FIX_PRICE);
        System.out.println("Товары первого магазина:");
        for (String s : s1.getItems() ) System.out.print(s+" ");
        System.out.println("\nСчастливый час: " + s1.getLuckyHour()+"\n");

        FixPriceShop s2 = new FixPriceShop(productsForShop2, FIX_PRICE);
        System.out.println("Товары вторго магазина:");
        for (String s : s2.getItems() ) System.out.print(s+" ");
        System.out.println("\nСчастливый час: " + s2.getLuckyHour()+"\n");

        FixPriceShop s3 = new FixPriceShop(productsForShop3, FIX_PRICE);
        System.out.println("Товары третьего магазина:");
        for (String s : s3.getItems() ) System.out.print(s+" ");
        System.out.println("\nСчастливый час: " + s3.getLuckyHour()+"\n");

        System.out.print("\nФиксированная цена: " + s1.getFixPrice()+"\n");
        System.out.println("Проверка цены товара " +s1.checkItemPrice("Пшено",
                s1.getLuckyHour())+" Время: " + s1.getLuckyHour());
        s1.buyItem("Пшено", 8);
        s1.buyItem("Пшено", 8);
        for (String s : s1.getItems() ) System.out.print(s+" ");


    }
}
