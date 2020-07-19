package org.serieznyi.FightOfWizards.character.wizard.spell;


import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Monster;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final public class BanishingMonsters implements Spell {
    /**
     * Количество урона наносимое заклинанием
     */
    private int damage;

    /**
     * Максимальное значение урона, до которого может усилиться заклинание
     */
    private final int maxDamage;

    public BanishingMonsters(int damage) {
        Assert.greaterThan(damage, 1);
        this.damage = damage;

        maxDamage = (int) (damage * 1.5F);
    }

    @Override
    public String getName() {
        return "Изгнание монстров";
    }

    @Override
    public String getDescription() {
        return "Наносит урон всем монстрам";
    }

    @Override
    public void cast(Character wizard, Scene scene) {

        List<String> damagedOpponentNames = new ArrayList<>();

        Map<Integer, Character> opponents = scene.getOpponentsFor(wizard);

        for (Map.Entry<Integer, Character> entry: opponents.entrySet()) {
            Character opponent = entry.getValue();

            if (opponent instanceof Monster) {
                opponent.decreaseHealth(damage);
                damagedOpponentNames.add(opponent.getName());
            }
        }

        String opponentNames = String.join(", ", damagedOpponentNames);

        System.out.printf("\t%s наносит урон монстрам \"%s\". Каждый получает \"%s\" единиц урона.\n", getName(), opponentNames, damage);

        strengthenSpell(wizard);
    }

    /**
     * С каждым применение заклинания растет его мощь
     */
    private void strengthenSpell(Character wizard)
    {
        if (damage < maxDamage) {
            damage+=5;

            System.out.printf("\tЗаклинание \"%s\" у мага \"%s\" усилилось\n", getName(), wizard.getName());
        }
    }
}
