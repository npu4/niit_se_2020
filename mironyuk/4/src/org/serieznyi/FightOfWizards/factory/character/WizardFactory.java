package org.serieznyi.FightOfWizards.factory.character;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Wizard;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.character.wizard.spell.BanishingMonsters;
import org.serieznyi.FightOfWizards.character.wizard.spell.Healing;
import org.serieznyi.FightOfWizards.character.wizard.spell.Lightning;
import org.serieznyi.FightOfWizards.factory.NameFactory;

import java.util.concurrent.ThreadLocalRandom;

final public class WizardFactory implements CharacterFactory {

    private static final int MIN_HEALTH = 70;
    private static final int MAX_HEALTH = 200;
    private static final int MIN_HEALING = 25;
    private static final int MAX_HEALING = 50;
    private static final int MIN_SPELL_DAMAGE = 50;
    private static final int MAX_SPELL_DAMAGE = 75;

    private final NameFactory nameFactory;

    public WizardFactory(NameFactory nameFactory) {
        this.nameFactory = nameFactory;
    }

    public Wizard create()
    {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        return new Wizard(
                nameFactory.nextName(Character.Type.WIZARD),
                random.nextInt(MIN_HEALTH, MAX_HEALTH + 1),
                new Spell[] {
                        new Healing(random.nextInt(MIN_HEALING, MAX_HEALING + 1)),
                        new Lightning(random.nextInt(MIN_SPELL_DAMAGE, MAX_SPELL_DAMAGE + 1)),
                        new BanishingMonsters(random.nextInt(MIN_SPELL_DAMAGE, MAX_SPELL_DAMAGE + 1))
                }
        );
    }
}
