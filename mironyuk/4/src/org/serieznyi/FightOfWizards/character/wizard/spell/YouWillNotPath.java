package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;

final public class YouWillNotPath extends Spell {
    public YouWillNotPath() {
        super("Ты не пройдешь!");
    }

    @Override
    protected void castInternal(Character character, Scene scene) {
    }
}
