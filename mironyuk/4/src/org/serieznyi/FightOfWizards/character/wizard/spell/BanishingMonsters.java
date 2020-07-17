package org.serieznyi.FightOfWizards.character.wizard.spell;


import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Monster;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Изгнание монстров - наносит урон всем монстрам.
 */
final public class BanishingMonsters extends Spell {
    /**
     * Количество урона наносимое заклинанием
     */
    private int damage;

    /**
     * Максимальное значение урона, до которого может усилиться заклинание
     */
    private final int maxDamage;

    public BanishingMonsters(int damage) {
        super("Изгнание монстров");

        Assert.greaterThan(damage, 1);
        this.damage = damage;

        maxDamage = (int) (damage * 1.5F);
    }

    @Override
    public void cast(Character wizard, Map<Integer, Character> opponents) {

        List<String> damagedOpponentNames = new ArrayList<>();

        for (Map.Entry<Integer, Character> entry: opponents.entrySet()) {
            Character opponent = entry.getValue();

            if (opponent instanceof Monster) {
                opponent.decreaseHealth(damage);
                damagedOpponentNames.add(opponent.getName());
            }
        }

        String opponentNames = String.join(", ", damagedOpponentNames);

        System.out.printf("\tЦепная молния ударяет по \"%s\". Каждый получает \"%s\" единиц урона.\n", opponentNames, damage);

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
