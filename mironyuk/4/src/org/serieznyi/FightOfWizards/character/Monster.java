package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.BasicAction;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize
public final class Monster extends Character {
  private final int damageSize;

  private Monster() {
    damageSize = 0;
  }

  public Monster(String name, int health, int damage) {
    super(Type.MONSTER, name, health);

    damageSize = damage;
  }

  @Override
  public BasicAction produceAction(Scene scene) {
    return CausingDamageAction
            .builder()
            .withInitiator(this)
            .addTarget(scene.getRandomOpponentFor(this))
            .causePhysicalDamage(damageSize)
            .build();
  }
}
