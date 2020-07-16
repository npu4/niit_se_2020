package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;

// Стена огня - наносит урон всем персонажам на четных позициях. 
final public class WallOfFire extends Spell {
    public WallOfFire(String name) {
        super(name);
    }

    @Override
    public void castInternal(Character character, Scene scene) {

    }
}
