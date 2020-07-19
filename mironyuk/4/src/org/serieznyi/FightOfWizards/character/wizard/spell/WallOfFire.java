package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final public class WallOfFire implements Spell {
    /**
     * Количество урона наносимое заклинанием
     */
    private int damage;

    /**
     * Максимальное значение урона, до которого может усилиться заклинание
     */
    private final int maxDamage;

    public WallOfFire(int damage) {
        Assert.greaterThan(damage, 1);
        this.damage = damage;

        maxDamage = (int) (damage * 1.5F);
    }

    @Override
    public String getName() {
        return "Стена огня";
    }

    @Override
    public String getDescription() {
        return "Наносит урон всем персонажам на четных позициях";
    }

    @Override
    public void cast(Character wizard, Scene scene) {
        Map<Integer, Character> opponents = scene.getOpponentsFor(wizard);

        List<String> damagedOpponentNames = new ArrayList<>();

        for (Map.Entry<Integer, Character> entry: opponents.entrySet()) {
            if (isOdd(entry.getKey())) {
                continue;
            }

            Character character = entry.getValue();
            character.decreaseHealth(damage);
            damagedOpponentNames.add(character.getName());
        }

        String opponentNames = String.join(", ", damagedOpponentNames);

        System.out.printf("\t%s ударяет по \"%s\". Каждый получает \"%s\" единиц урона.\n", getName(), opponentNames, damage);

        strengthenSpell(wizard);
    }

    private boolean isOdd(Integer number) {
        return number % 2 != 0;
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
