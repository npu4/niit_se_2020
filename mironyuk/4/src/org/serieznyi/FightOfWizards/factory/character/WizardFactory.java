package org.serieznyi.FightOfWizards.factory.character;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Wizard;
import org.serieznyi.FightOfWizards.factory.NameFactory;
import org.serieznyi.FightOfWizards.factory.SpellBagFactory;

import java.util.concurrent.ThreadLocalRandom;

final public class WizardFactory implements CharacterFactory {

    private static final int MIN_HEALTH = 70;
    private static final int MAX_HEALTH = 200;

    private final NameFactory nameFactory;
    private final SpellBagFactory spellBagFactory;

    public WizardFactory(NameFactory nameFactory, SpellBagFactory spellBagFactory) {
        this.nameFactory = nameFactory;
        this.spellBagFactory = spellBagFactory;
    }

    public Wizard create()
    {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        return new Wizard(
                nameFactory.nextName(Character.Type.WIZARD),
                random.nextInt(MIN_HEALTH, MAX_HEALTH + 1),
                spellBagFactory.create()
        );
    }
}
