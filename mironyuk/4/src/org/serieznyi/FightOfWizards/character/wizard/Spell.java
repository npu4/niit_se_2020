package org.serieznyi.FightOfWizards.character.wizard;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.character.Character;

public interface Spell {
  String getName();

  String getDescription();

  Action cast(Character wizard, Scene scene);
}
