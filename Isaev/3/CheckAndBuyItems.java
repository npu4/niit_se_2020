public class CheckAndBuyItems {

    public static void main(String[] args) {


        String[] firstShopItems = {"cat", "dog", "wolf", "horse"};
        String[] secondShopItems = {"coffee", "tea", "lemonade", "beer"};
        String[] thirdShopItems = {"pen", "pencil", "notebook", "pencil case"};

        FixPriceShop firstShop = new FixPriceShop(firstShopItems, 10);
        FixPriceShop secondShop = new FixPriceShop(secondShopItems, 12);
        FixPriceShop thirdShop = new FixPriceShop(thirdShopItems, 16);

        firstShop.bestBuyTime("dog",8);
        secondShop.bestBuyTime("tea",12);
        thirdShop.bestBuyTime("notebook",15);

        firstShop.buyItem("dog",10);
        firstShop.buyItem("dog",10);

    }
}
