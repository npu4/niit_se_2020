package org.serieznyi.FightOfWizards.factory.character;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Wizard;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.character.wizard.spell.YouWillNotPath;
import org.serieznyi.FightOfWizards.factory.NameFactory;

import java.util.concurrent.ThreadLocalRandom;

final public class WizardFactory implements CharacterFactory {

    private static final int MIN_HEALTH = 50;
    private static final int MAX_HEALTH = 100;

    private final NameFactory nameFactory;

    public WizardFactory(NameFactory nameFactory) {
        this.nameFactory = nameFactory;
    }

    public Wizard create()
    {
        return new Wizard(
                nameFactory.nextName(Character.Type.WIZARD),
                ThreadLocalRandom.current().nextInt(MIN_HEALTH, MAX_HEALTH),
                new Spell[] {new YouWillNotPath()}
        );
    }
}
