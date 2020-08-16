package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.util.Assert;

public final class HealingAction extends BasicAction {
  private int value;

  private HealingAction()
  {
    super();
  }

  public static Builder builder()
  {
    return new Builder();
  }

  private HealingAction(Builder builder) {
    super(builder);

    this.value = builder.value;
  }

  public int getValue() {
    return value;
  }

  public static class Builder extends BasicAction.Builder<Builder> {
    int value;

    protected Builder() {
      super();
    }

    protected void check()
    {
      super.check();

      Assert.greaterThan(value, 1, "Значение не может быть меньше единицы");
    }

    public Builder withValue(int value)
    {
      this.value = value;

      return this;
    }

    public HealingAction build()
    {
      check();

      return new HealingAction(this);
    }
  }
}
