package battle.spell;

import battle.characters.Character;
import battle.characters.Wizard;

import java.util.ArrayList;
import java.util.List;

public abstract class Spell extends Wizard{
    List<Character> targets = new ArrayList<>();

    public abstract String cast(Character[] characters, Wizard attacker);

}
