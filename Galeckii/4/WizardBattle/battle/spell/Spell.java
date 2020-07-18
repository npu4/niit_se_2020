package battle.spell;

import battle.characters.Character;
import battle.characters.Wizard;

public abstract class Spell extends Wizard{

    public abstract void cast(Character[] characters, Wizard attacker);

}
