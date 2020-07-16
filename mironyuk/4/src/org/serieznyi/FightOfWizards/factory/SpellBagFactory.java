package org.serieznyi.FightOfWizards.factory;

import org.serieznyi.FightOfWizards.character.wizard.Spell;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SpellBagFactory {
    private final static int DEFAULT_SIZE_OF_SPELLS_BAG = 3;

    private final Spell[] allowedSpells;

    SpellBagFactory(Spell[] allowedSpells)
    {
        if (allowedSpells.length == 0) {
            throw new IllegalArgumentException("Массив доступных заклинаний не может быть пустым");
        }

        this.allowedSpells = allowedSpells;
    }

    public Spell[] create() {
        return create(DEFAULT_SIZE_OF_SPELLS_BAG);
    }

    public Spell[] create(int count) {

        return Arrays.stream(allowedSpells)
                .sorted((Spell s1, Spell s2) -> ThreadLocalRandom.current().nextInt(0, -1))
                .limit(count)
                .toArray(Spell[]::new);
    }
}
