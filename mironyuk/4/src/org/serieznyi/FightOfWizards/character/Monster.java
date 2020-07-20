package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;

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

    opponent.reactOnAction(CausingDamageAction.of(CausingDamageAction.Type.PHYSICAL, damageSize));

    System.out.printf(
        "Монстр \"%s\" атакует \"%s\" на %s единиц урона\n", name, opponent.name, damageSize);
  }
}
