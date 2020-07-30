package Shops.items;

public class Refrigerator extends ElectronicItem {
    int freezerVolume;

    public Refrigerator(String name, int price, int powerConsumption, int freezerVolume) {
        super(name, price, powerConsumption);
        this.freezerVolume = freezerVolume;
    }
}
