public class TV extends ElectronicItem {

    int volume;

    public TV(String name, int price, int power, int volume) {
        super(name, price, power);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
