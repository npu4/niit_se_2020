package Shops.items;

public class Bread extends FoodItem {
    int weight;

    public Bread(String name, int price, int calorieContent, int expirationDate, int weight) {
        super(name, price, calorieContent, expirationDate);
        this.weight = weight;
    }
}
