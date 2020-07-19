package org.serieznyi.FightOfWizards.character.wizard;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;

public interface Spell {
    String getName();

    String getDescription();

    void cast(Character wizard, Scene scene);
}
