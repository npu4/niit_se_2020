package Shops.items;

public class Apple extends FoodItem{
    String color;

    public Apple(String name, int price, int calorieContent, int expirationDate, String color) {
        super(name, price, calorieContent, expirationDate);
        this.color = color;
    }
}
