package Shops.items;

public class TV extends ElectronicItem {
    int volume;

    public TV(String name, int price, int powerConsumption, int volume) {
        super(name, price, powerConsumption);
        this.volume = volume;
    }
}
