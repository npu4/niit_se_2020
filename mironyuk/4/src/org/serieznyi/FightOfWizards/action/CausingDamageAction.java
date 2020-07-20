package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.util.Assert;

public final class CausingDamageAction implements Action {
  public enum Type {
    PHYSICAL,
    FIRE,
    LIGHTNING,
    MAGICAL,
  }

  private final Type type;

  private final int damage;

  public CausingDamageAction(Type type, int damage) {
    this.type = type;

    Assert.greaterThan(damage, 1);
    this.damage = damage;
  }

  public static Action causeFireDamage(int value)
  {
    return new CausingDamageAction(Type.FIRE, value);
  }

  public static Action causePhysicalDamage(int value)
  {
    return new CausingDamageAction(Type.PHYSICAL, value);
  }

  public static Action causeMagicalDamage(int value)
  {
    return new CausingDamageAction(Type.MAGICAL, value);
  }

  public static Action causeLightingDamage(int value)
  {
    return new CausingDamageAction(Type.LIGHTNING, value);
  }

  public static Action of(Type type, int value) {
    return new CausingDamageAction(type, value);
  }

  public int getDamage() {
    return damage;
  }

  public Action.Type getType() {
    return Action.Type.DAMAGE;
  }

  public Type getDamageType() {
    return type;
  }
}
