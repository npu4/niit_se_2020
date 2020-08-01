package org.serieznyi.shop.item.food;

import org.serieznyi.shop.item.FoodItem;

public final class Apple extends FoodItem {
  private final Color color;

  public Apple(String name, int price, int calorific, int expirationDateInDays, Color color) {
    super(name, price, calorific, expirationDateInDays);
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public enum Color {
    RED("Красное"),
    GREEN("Зеленое"),
    ORANGE("Оранжевое"),
    YELLOW("Желтое");

    private final String color;

    Color(String color) {
      this.color = color;
    }

    @Override
    public String toString() {
      return color;
    }
  }
}
