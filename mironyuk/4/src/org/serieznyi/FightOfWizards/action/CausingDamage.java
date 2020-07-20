package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.util.Assert;

public final class CausingDamage implements Action {
  public enum Type {
    PHYSICAL,
    FIRE,
    LIGHTNING,
    MAGICAL,
  }

  private final Type type;

  private final int damage;

  public CausingDamage(Type type, int damage) {
    this.type = type;

    Assert.greaterThan(damage, 1);
    this.damage = damage;
  }

  public static Action causeFireDamage(int value)
  {
    return new CausingDamage(Type.FIRE, value);
  }

  public static Action causePhysicalDamage(int value)
  {
    return new CausingDamage(Type.PHYSICAL, value);
  }

  public static Action causeMagicalDamage(int value)
  {
    return new CausingDamage(Type.MAGICAL, value);
  }

  public static Action causeLightingDamage(int value)
  {
    return new CausingDamage(Type.LIGHTNING, value);
  }

  public static Action of(Type type, int value) {
    return new CausingDamage(type, value);
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
