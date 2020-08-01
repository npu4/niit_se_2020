package org.serieznyi.shop.item.food;

import org.serieznyi.shop.item.FoodItem;
import org.serieznyi.shop.util.Assert;

public final class Bread extends FoodItem {
  private final int weightInGrams;

  public Bread(String name, int price, int calorific, int expirationDateInDays, int weightInGrams) {
    super(name, price, calorific, expirationDateInDays);

    Assert.greaterThan(weightInGrams, 0);
    this.weightInGrams = weightInGrams;
  }

  public int getWeightInGrams() {
    return weightInGrams;
  }
}
