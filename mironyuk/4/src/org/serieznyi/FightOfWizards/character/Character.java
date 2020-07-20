package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.FightOfWizards.action.HealingAction;
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

  protected int decreaseHealth(int value) {
    return health.decreaseHealth(value);
  }

  protected int increaseHealth(int value) {
    return health.increaseHealth(value);
  }

  public boolean isType(Type type)
  {
    return this.type.equals(type);
  }

  /**
   * @param action Действие применяемое к персонажу
   * @return boolean возвращает True если действие повлияло на персонажа
   */
  public boolean reactOnAction(Action action)
  {
    if (action instanceof HealingAction) {
      return reactOnHealingAction((HealingAction) action);
    } else if (action instanceof CausingDamageAction) {
      return reactOnCausingDamageAction((CausingDamageAction) action);
    }

    return false;
  }

  /**
   * @param action Действие применяемое к персонажу
   * @return boolean возвращает True если действие повлияло на персонажа
   */
  public boolean reactOnHealingAction(HealingAction action)
  {
    return false;
  }

  /**
   * @param action Действие применяемое к персонажу
   * @return boolean возвращает True если действие повлияло на персонажа
   */
  public boolean reactOnCausingDamageAction(CausingDamageAction action)
  {
    int oldHealth = getHealth();
    int newHealth = decreaseHealth(action.getDamage());

    return oldHealth != newHealth;
  }

  public enum Type {
    MONSTER {
      @Override
      public String toString() {
        return "Монстр";
      }
    },
    WIZARD {
      @Override
      public String toString() {
        return "Маг";
      }
    }
  }

  private static class Health {
    protected final int initialHealth;
    protected int health;

    private Health(int health) {
      Assert.greaterThan(health, 1);
      this.health = initialHealth = health;
    }

    public int decreaseHealth(int health) {
      this.health -= health;

      return this.health;
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
