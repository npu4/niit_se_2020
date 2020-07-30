package products;
import java.util.Objects;

public abstract class ShopItem {
    String productName;
    Double priceProduct;

    public ShopItem(String productName, Double priceProduct) {
        this.productName = productName;
        this.priceProduct = priceProduct;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "productName='" + productName + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;
        return Objects.equals(productName, shopItem.productName) &&
                Objects.equals(priceProduct, shopItem.priceProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, priceProduct);
    }
}

