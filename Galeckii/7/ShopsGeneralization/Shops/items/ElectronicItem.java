package Shops.items;

public class ElectronicItem extends ShopItem{
    private int powerConsumption;

    public ElectronicItem(String name, int price, int powerConsumption) {
        super(name, price);
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

}
