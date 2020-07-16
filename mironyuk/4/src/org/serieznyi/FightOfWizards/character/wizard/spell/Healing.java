package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;

//Исцеление - добавляет очков здоровья магу, произнесшему заклинания. 
final public class Healing extends Spell {
    public Healing(String name) {
        super(name);
    }

    @Override
    public void castInternal(Character character, Scene scene) {

    }
}
