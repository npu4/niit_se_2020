public class Apple extends FoodItem {

    String color;

    public Apple(String name, int price, int calorie, int shelfLife, String color) {
        super(name, price, calorie, shelfLife);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
