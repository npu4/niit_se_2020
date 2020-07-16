package org.serieznyi.FightOfWizards.character.wizard;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.util.Assert;

abstract public class Spell {
    private final String name;

    public Spell(String name) {
        Assert.requireNotEmptyString(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void cast(Scene scene)
    {
        System.out.printf("Маг %s читает заклинание %s", 1, 1);
    }

    protected abstract void castInternal(Character character, Scene scene);
}
