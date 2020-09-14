package shop.items;

public class Apple extends FoodItem{
    private final ColorOfApple color;
    private static int counter;

    public Apple(Integer price, ColorOfApple color){
        this.setName("Яблоко № " + ++counter);
        this.setPrice(price);
        this.color = color;
    }

    public String getColor() {
        return color.getColor();
    }
}


