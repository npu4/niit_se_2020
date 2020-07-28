package org.serieznyi.shop.item;

import org.serieznyi.shop.util.Assert;

public abstract class ShopItem {
    String name;
    int price;

    protected ShopItem(String name, int price)
    {
        Assert.greaterThan(price, 0);
        this.price = price;

        Assert.requireNotEmpty(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
