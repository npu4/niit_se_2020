package org.serieznyi.shop.item.electronic;

import org.serieznyi.shop.item.ElectronicItem;
import org.serieznyi.shop.util.Assert;

final public class Refrigerator extends ElectronicItem {
    private final int chamberVolume;

    public Refrigerator(String name, int price, int power, int chamberVolume) {
        super(name, price, power);

        Assert.greaterThan(chamberVolume, 0);
        this.chamberVolume = chamberVolume;
    }

    public int getChamberVolume() {
        return chamberVolume;
    }
}
