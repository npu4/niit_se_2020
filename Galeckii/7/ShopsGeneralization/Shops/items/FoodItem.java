package Shops.items;

public class FoodItem extends ShopItem {
    int calorieContent;
    int expirationDate;

    public FoodItem(String name, int price, int calorieContent, int expirationDate) {
        super(name, price);
        this.calorieContent = calorieContent;
        this.expirationDate = expirationDate;
    }
}
