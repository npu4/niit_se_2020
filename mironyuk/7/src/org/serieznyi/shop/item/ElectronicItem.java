package org.serieznyi.shop.item;

import org.serieznyi.shop.util.Assert;

public abstract class ElectronicItem extends ShopItem {
  private final int power;

  protected ElectronicItem(String name, int price, int power) {
    super(name, price);

    Assert.greaterThan(power, 0);
    this.power = power;
  }

  public int getPower() {
    return power;
  }
}
