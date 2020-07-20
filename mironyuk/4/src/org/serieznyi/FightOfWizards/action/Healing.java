package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.util.Assert;

public final class Healing implements Action {
  private final int value;

  public Healing(int value) {
    Assert.greaterThan(value, 1);
    this.value = value;
  }

  public static Action of(int value) {
    return new Healing(value);
  }

  public Type getType() {
    return Type.HEALING;
  }

  public int getValue() {
    return value;
  }
}
