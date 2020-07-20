package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.action.CausingDamage;

/** - Монстры восстанавливают немного здоровья после своего действия */
public final class Monster extends Character {
  private final int damageSize;

  public Monster(String name, int health, int damage) {
    super(Type.MONSTER, name, health);

    damageSize = damage;
  }

  @Override
  public void action(Scene scene) {
    Character opponent = scene.getRandomOpponentFor(this);

    opponent.reactOnAction(CausingDamage.of(CausingDamage.Type.PHYSICAL, damageSize));

    System.out.printf(
        "Монстр \"%s\" атакует \"%s\" на %s единиц урона\n", name, opponent.name, damageSize);
  }

  @Override
  public boolean reactOnAction(Action action) {
    if (action instanceof CausingDamage) {
      CausingDamage causingDamage = (CausingDamage) action;

      decreaseHealth(causingDamage.getDamage());

      return true;
    }

    return false;
  }
}
