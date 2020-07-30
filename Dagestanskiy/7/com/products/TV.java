package products;
import java.util.Objects;

public class TV extends ElectronicItem {
    Integer volume;

    public TV(String productName, Double priceProduct, Double powerConsumption, Integer volume) {
        super(productName, priceProduct, powerConsumption);
        this.volume = volume;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TV tv = (TV) o;
        return Objects.equals(volume, tv.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }

    @Override
    public String toString() {
        return "TV{" +
                "volume=" + volume +
                ", powerConsumption=" + powerConsumption +
                ", productName='" + productName + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }
}
