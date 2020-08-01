public class Refrigerator extends  ElectronicItem {

    int freezerVolume;

    public Refrigerator(String name, int price, int power, int freezerVolume) {
        super(name, price, power);
        this.freezerVolume = freezerVolume;
    }

    public int getFreezerVolume() {
        return freezerVolume;
    }

    public void setFreezerVolume(int freezerVolume) {
        this.freezerVolume = freezerVolume;
    }
}
