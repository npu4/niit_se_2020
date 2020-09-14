package shop.items;

public class TV extends ElectronicItem {
    private static int counter;
    private Integer volume;

    public TV(Integer price, Integer powerConsumption, Integer volume){
        this.setName("Телевизор № " + ++counter);
        this.setPrice(price);
        this.setPowerConsumption(powerConsumption);
        this.volume = volume;
    }

    public TV(String name, Integer price, Integer powerConsumption, Integer volume){
        this.setName(name);
        this.setPrice(price);
        this.setPowerConsumption(powerConsumption);
        this.setVolume(volume);
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
