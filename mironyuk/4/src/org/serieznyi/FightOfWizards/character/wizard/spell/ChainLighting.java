package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Цепная молния - наносит урон, всем персонажам на сцене, кроме мага, который произносит заклинание.
 */
final public class ChainLighting extends Spell {
    /**
     * Количество урона наносимое заклинанием
     */
    private int damage;

    /**
     * Максимальное значение урона, до которого может усилиться заклинание
     */
    private final int maxDamage;

    public ChainLighting(int damage) {
        super("Цепная молния");

        Assert.greaterThan(damage, 1);
        this.damage = damage;

        maxDamage = (int) (damage * 1.5F);
    }

    @Override
    public void cast(Character wizard, Map<Integer, Character> opponents) {

        List<String> damagedOpponentNames = new ArrayList<>();

        for (Character character : opponents.values()) {
            character.decreaseHealth(damage);
            damagedOpponentNames.add(character.getName());
        }

        String opponentNames = String.join(", ", damagedOpponentNames);

        System.out.printf("\t%s ударяет по \"%s\". Каждый получает \"%s\" единиц урона.\n", name, opponentNames, damage);

        strengthenSpell(wizard);
    }

    /**
     * С каждым применение заклинания растет его мощь
     */
    private void strengthenSpell(Character wizard)
    {
        if (damage < maxDamage) {
            damage+=5;

            System.out.printf("\tЗаклинание \"%s\" у мага \"%s\" усилилось\n", name, wizard.getName());
        }
    }
}
