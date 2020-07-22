package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.util.Assert;

public final class HealingAction implements Action {
  private final int value;

  public HealingAction(int value) {
    Assert.greaterThan(value, 1);
    this.value = value;
  }

  public static Action of(int value) {
    return new HealingAction(value);
  }

  public Type getType() {
    return Type.HEALING;
  }

  public int getValue() {
    return value;
  }
}
