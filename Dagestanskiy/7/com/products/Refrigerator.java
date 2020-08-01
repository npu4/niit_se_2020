package products;
import java.util.Objects;

public class Refrigerator extends ElectronicItem {
    Integer freezerVolume;

    public Refrigerator(String productName, Double priceProduct,
                        Double powerConsumption, Integer freezerVolume) {
        super(productName, priceProduct, powerConsumption);
        this.freezerVolume = freezerVolume;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Refrigerator that = (Refrigerator) o;
        return Objects.equals(freezerVolume, that.freezerVolume);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), freezerVolume);
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "freezerVolume=" + freezerVolume +
                ", powerConsumption=" + powerConsumption +
                ", productName='" + productName + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }
}
