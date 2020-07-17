package org.serieznyi.FightOfWizards.character.wizard;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.Map;

abstract public class Spell {
    protected final String name;

    public Spell(String name) {
        Assert.requireNotEmptyString(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public void cast(Character wizard, Map<Integer, Character> opponents);
}
