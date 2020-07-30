package products;
import java.util.Objects;

public abstract class FoodItem extends ShopItem {
    Integer calorieContent;
    Integer shelfLife;

    public FoodItem(String productName, Double priceProduct, Integer calorieContent, Integer shelfLife) {
        super(productName, priceProduct);
        this.calorieContent = calorieContent;
        this.shelfLife = shelfLife;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return Objects.equals(calorieContent, foodItem.calorieContent) &&
                Objects.equals(shelfLife, foodItem.shelfLife);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), calorieContent, shelfLife);
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "calorieContent=" + calorieContent +
                ", shelfLife=" + shelfLife +
                ", productName='" + productName + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }
}
