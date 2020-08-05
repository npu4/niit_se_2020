package shop.products;

import shop.items.ElectronicItem;

public class TV extends ElectronicItem {

    private static final String DEFAULT_NAME = "Телевизор";
    private static final int DEFAULT_VOLUME = 100;
    private int volumeValue;

    public TV() {
        super(DEFAULT_NAME);
        this.volumeValue = DEFAULT_VOLUME;
    }

    public int getVolumeValue() {
        return volumeValue;
    }

    public void setVolumeValue(int volumeValue) {
        this.volumeValue = volumeValue;
    }
}
