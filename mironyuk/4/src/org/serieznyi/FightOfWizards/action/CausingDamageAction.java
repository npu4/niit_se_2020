package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.util.Assert;


public final class CausingDamageAction extends Action {
  private final Type type;
  private final int damage;

  public static CausingDamageAction.Builder builder()
  {
    return new CausingDamageAction.Builder();
  }

  private CausingDamageAction(Builder builder) {
    super(builder);

    this.type = builder.type;

    this.damage = builder.damage;
  }

  public int getDamage() {
    return damage;
  }

  public Type getDamageType() {
    return type;
  }

  public static class Builder extends Action.Builder<Builder> {
    Type type;
    int damage;

    private Builder() {
      super();
    }

    protected void check() {
      super.check();

      Assert.greaterThan(damage, 1, "Урон не может быть меньше единицы");
    }

    public CausingDamageAction build()
    {
      check();

      return new CausingDamageAction(this);
    }

    public CausingDamageAction.Builder withDamage(int value) {
      this.damage = value;

      return this;
    }

    public CausingDamageAction.Builder withType(Type type) {
      this.type = type;

      return this;
    }

    public Builder causeFireDamage(int damage) {
      type = Type.FIRE;
      this.damage = damage;

      return this;
    }

    public Builder causePhysicalDamage(int damage) {
      type = Type.PHYSICAL;
      this.damage = damage;

      return this;
    }

    public Builder causeMagicalDamage(int damage) {
      type = Type.MAGICAL;
      this.damage = damage;

      return this;
    }

    public Builder causeLightingDamage(int damage) {
      type = Type.LIGHTNING;
      this.damage = damage;

      return this;
    }
}

  public enum Type {
    PHYSICAL,
    FIRE,
    LIGHTNING,
    MAGICAL,
  }
}
