package org.serieznyi.shop.item.electronic;

import org.serieznyi.shop.item.ElectronicItem;
import org.serieznyi.shop.util.Assert;

final public class TV extends ElectronicItem {
    private final int volume;

    public TV(String name, int price, int power, int volume) {
        super(name, price, power);

        Assert.greaterOrEqualsThan(volume, 0);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}
