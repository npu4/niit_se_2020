package org.serieznyi.FightOfWizards.factory.character;

import org.serieznyi.FightOfWizards.character.Character;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomCharacterFactory implements CharacterFactory {
  private final CharacterFactory[] characterFactories;

  public RandomCharacterFactory(CharacterFactory[] characterFactories) {
    this.characterFactories = characterFactories;
  }

  @Override
  public Character create() {
    int typeCharacterIndex = ThreadLocalRandom.current().nextInt(0, characterFactories.length);

    return characterFactories[typeCharacterIndex].create();
  }
}
