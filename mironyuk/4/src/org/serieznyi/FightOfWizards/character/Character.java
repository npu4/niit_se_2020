package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.util.Assert;

public abstract class Character {
  private final Health health;

  protected String name;

  protected Type type;

  public Character(Type type, String name, int health) {
    Assert.requireNotEmptyString(name);
    this.name = name;

    this.type = type;

    this.health = new Health(health);
  }

  public int getHealth() {
    return health.getHealth();
  }

  public Type getType() {
    return type;
  }

  public abstract void action(Scene scene);

  public String toString() {
    return name;
  }

  public String getName() {
    return name;
  }

  public boolean isDead() {
    return health.isDead();
  }

  public void decreaseHealth(int value) {
    health.decreaseHealth(value);
  }

  public int increaseHealth(int value) {
    return health.increaseHealth(value);
  }

  public boolean isType(Type type)
  {
    return this.type.equals(type);
  }

  abstract public boolean reactOnAction(Action action);

  public enum Type {
    MONSTER,
    WIZARD
  }

  private static class Health {
    protected final int initialHealth;
    protected int health;

    private Health(int health) {
      Assert.greaterThan(health, 1);
      this.health = initialHealth = health;
    }

    public void decreaseHealth(int health) {
      this.health -= health;
    }

    /**
     * @param health value to increase health
     * @return new health value
     */
    public int increaseHealth(int health) {
      if (isHealthLowerInitialHealth()) {
        this.health += health;
      }

      return this.health;
    }

    private boolean isHealthLowerInitialHealth() {
      return this.health < initialHealth;
    }

    public int getHealth() {
      return health;
    }

    public boolean isDead() {
      return health <= 0;
    }
  }
}
