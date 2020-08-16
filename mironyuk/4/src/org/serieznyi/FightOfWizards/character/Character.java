package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.FightOfWizards.action.HealingAction;
import org.serieznyi.FightOfWizards.action.result.CausingDamageResult;
import org.serieznyi.FightOfWizards.action.result.NoneResult;
import org.serieznyi.FightOfWizards.action.result.Result;
import org.serieznyi.FightOfWizards.util.Assert;
import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize
public abstract class Character {
  protected int initialHealth;

  protected int health;

  protected String name;

  protected Type type;

  protected Character() {}

  public Character(Type type, String name, int health) {
    Assert.requireNotEmptyString(name);
    this.name = name;

    this.type = type;

    this.health = this.initialHealth = health;
  }

  protected int decreaseHealth(int health) {
    this.health -= health;

    return this.health;
  }

  /**
   * @param health value to increase health
   * @return new health value
   */
  protected int increaseHealth(int health) {
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

  public Type getType() {
    return type;
  }

  public abstract Action produceAction(Scene scene);

  public String toString() {
    return name;
  }

  public String getName() {
    return name;
  }

  /**
   * @param action Действие применяемое к персонажу
   * @return boolean возвращает True если действие повлияло на персонажа
   */
  public Result reactOnAction(Action action) {
    if (action instanceof HealingAction) {
      return reactOnHealingAction((HealingAction) action);
    } else if (action instanceof CausingDamageAction) {
      return reactOnCausingDamageAction((CausingDamageAction) action);
    }

    return NoneResult.INSTANCE;
  }

  /**
   * @param action Действие применяемое к персонажу
   * @return boolean возвращает True если действие повлияло на персонажа
   */
  public Result reactOnHealingAction(HealingAction action) {
    return NoneResult.INSTANCE;
  }

  /**
   * @param action Действие применяемое к персонажу
   * @return boolean возвращает True если действие повлияло на персонажа
   */
  public Result reactOnCausingDamageAction(CausingDamageAction action) {
    int oldHealth = getHealth();
    int newHealth = decreaseHealth(action.getDamage());

    return new CausingDamageResult(
            oldHealth != newHealth,
            action.getDamage(),
            action.getDamage(),
            newHealth
    );
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
}
