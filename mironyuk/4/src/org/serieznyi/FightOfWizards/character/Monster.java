package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.FightOfWizards.logging.Logger;

public final class Monster extends Character {
  static final Logger LOGGER = Logger.create();

  private final int damageSize;

  public Monster(String name, int health, int damage) {
    super(Type.MONSTER, name, health);

    damageSize = damage;
  }

  @Override
  public void applyAction(Scene scene) {
    Character opponent = scene.getRandomOpponentFor(this);

    LOGGER.characterAttack(this, opponent);

    boolean damaged = opponent.reactOnAction(CausingDamageAction.causePhysicalDamage(damageSize));

    if (damaged) {
      LOGGER.takeDamageTo(this, opponent, damageSize);
    }
  }
}
