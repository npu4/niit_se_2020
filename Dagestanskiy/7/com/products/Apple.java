package products;
import java.util.Objects;

public class Apple extends FoodItem {
    String colour;

    public Apple(String productName, Double priceProduct,
                 Integer calorieContent, Integer shelfLife, String colour) {
        super(productName, priceProduct, calorieContent, shelfLife);
        this.colour = colour;
    }


    public String getColour() {
        return colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apple apple = (Apple) o;
        return Objects.equals(colour, apple.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), colour);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "colour='" + colour + '\'' +
                ", calorieContent=" + calorieContent +
                ", shelfLife=" + shelfLife +
                ", productName='" + productName + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }
}
