package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.character.wizard.spell.YouWillNotPath;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

final public class Wizard extends Character {
    private List<Spell> spells;

    public Wizard(String name, int health, Spell[] spells) {
        super(name, health);

        if (spells.length > 3) {
            throw new IllegalArgumentException("Истинный волшебник использует не более 3х заклинаний");
        }

        this.spells = Arrays.asList(spells);
    }

    public Spell takeSomeSpell() {
        Optional<Spell> someSpell = spells.stream().findAny();

        if (!someSpell.isPresent()) {
            throw new RuntimeException("Что-то пошло не так");
        }

        return someSpell.get();
    }

    @Override
    public void action(Map<Integer, Character> opponents) {
        Spell spell = takeSomeSpell();

    System.out.printf("Маг \"%s\" читает заклинание \"%s\"\n", name, spell.getName());
    }
}
