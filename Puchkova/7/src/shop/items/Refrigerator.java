package shop.items;

public class Refrigerator extends ElectronicItem {
    private Integer freezerVolume;
    private static int counter;

    public Refrigerator(Integer price, Integer powerConsumption, Integer freezerVolume){
        this.setName("Холодильник № " + ++counter);
        this.setPrice(price);
        this.setPowerConsumption(powerConsumption);
        this.setFreezerVolume(freezerVolume);
    }

    public Refrigerator(String name, Integer price, Integer powerConsumption, Integer freezerVolume){
        this.setName(name);
        this.setPrice(price);
        this.setPowerConsumption(powerConsumption);
        this.setFreezerVolume(freezerVolume);
    }

    public Integer getFreezerVolume() {
        return freezerVolume;
    }

    public void setFreezerVolume(Integer freezerVolume) {
        this.freezerVolume = freezerVolume;
    }
}
