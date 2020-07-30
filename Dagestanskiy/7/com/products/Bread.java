package products;
import java.util.Objects;

public class Bread extends FoodItem{
    Integer weight;

    public Bread(String productName, Double priceProduct,
                 Integer calorieContent, Integer shelfLife, Integer weight) {
        super(productName, priceProduct, calorieContent, shelfLife);
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bread bread = (Bread) o;
        return Objects.equals(weight, bread.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }

    @Override
    public String toString() {
        return "Bread{" +
                "weight=" + weight +
                ", calorieContent=" + calorieContent +
                ", shelfLife=" + shelfLife +
                ", productName='" + productName + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }
}
