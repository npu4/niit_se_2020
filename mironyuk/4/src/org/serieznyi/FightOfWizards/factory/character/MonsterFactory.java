package org.serieznyi.FightOfWizards.factory.character;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Monster;
import org.serieznyi.FightOfWizards.factory.NameFactory;

import java.util.concurrent.ThreadLocalRandom;

public final class MonsterFactory implements CharacterFactory {
  private static final int MIN_HEALTH = 200;
  private static final int MAX_HEALTH = 400;

  private static final int MIN_DAMAGE = 20;
  private static final int MAX_DAMAGE = 45;

  private final NameFactory nameFactory;

  public MonsterFactory(NameFactory nameFactory) {
    this.nameFactory = nameFactory;
  }

  public Monster create() {
    return new Monster(
        nameFactory.nextName(Character.Type.MONSTER),
        ThreadLocalRandom.current().nextInt(MIN_HEALTH, MAX_HEALTH + 1),
        ThreadLocalRandom.current().nextInt(MIN_DAMAGE, MAX_DAMAGE + 1));
  }
}
