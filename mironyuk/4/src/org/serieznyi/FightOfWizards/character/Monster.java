package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.FightOfWizards.action.result.Result;
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

    Action action = CausingDamageAction
            .builder()
            .withAggressor(this)
            .addTarget(opponent)
            .causePhysicalDamage(damageSize)
            .build();

    Result result = opponent.reactOnAction(action);

    if (result.isSuccessful()) {
      LOGGER.takeDamageTo(this, opponent, damageSize);
    }
  }
}
