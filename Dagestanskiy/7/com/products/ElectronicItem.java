package products;
import java.util.Objects;

public abstract class ElectronicItem extends ShopItem {
Double powerConsumption;

    public ElectronicItem(String productName, Double priceProduct, Double powerConsumption) {
        super(productName, priceProduct);
        this.powerConsumption = powerConsumption;
    }

    public Double getPowerConsumption() {
        return powerConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectronicItem that = (ElectronicItem) o;
        return Objects.equals(powerConsumption, that.powerConsumption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), powerConsumption);
    }

    @Override
    public String toString() {
        return "ElectronicItem{" +
                "powerConsumption=" + powerConsumption +
                ", productName='" + productName + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }

}
