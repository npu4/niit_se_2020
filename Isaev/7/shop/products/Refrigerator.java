package shop.products;

import shop.items.ElectronicItem;

import java.util.Random;

public class Refrigerator extends ElectronicItem {

    private static final String DEFAULT_NAME = "Холодильник";
    private final int freezerCapacity;
    private final int[] freezer = {100, 150};

    public Refrigerator() {
        super(DEFAULT_NAME);
        this.freezerCapacity = freezer[new Random().nextInt(freezer.length - 1)];
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }
}
