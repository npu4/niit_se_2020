package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.FightOfWizards.logging.Logger;

/** - Монстры восстанавливают немного здоровья после своего действия */
public final class Monster extends Character {
  final static Logger LOGGER = Logger.create();

  private final int damageSize;

  public Monster(String name, int health, int damage) {
    super(Type.MONSTER, name, health);

    damageSize = damage;
  }

  @Override
  public void action(Scene scene) {
    Character opponent = scene.getRandomOpponentFor(this);

    LOGGER.characterAttack(this, opponent);

    boolean damaged = opponent.reactOnAction(CausingDamageAction.of(CausingDamageAction.Type.PHYSICAL, damageSize));

    if (damaged) {
      LOGGER.takeDamageTo(this, opponent, damageSize);
    }
  }
}
