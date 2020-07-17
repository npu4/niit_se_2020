package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;
import org.serieznyi.FightOfWizards.util.FightHelper;

import java.util.Map;

/**
 * Молния - наносит урон любому персонажу.
 */
final public class Lightning extends Spell {
    /**
     * Количество урона наносимое заклинанием
     */
    private int damage;

    /**
     * Максимальное значение урона, до которого может усилиться заклинание
     */
    private final int maxDamage;

    public Lightning(int damage) {
        super("Молния");

        Assert.greaterThan(damage, 1);
        this.damage = damage;

        maxDamage = (int) (damage * 1.5F);
    }

    @Override
    public void cast(Character wizard, Map<Integer, Character> opponents) {
        Character opponent = FightHelper.getRandomOpponentFrom(opponents);

        opponent.decreaseHealth(damage);

        System.out.printf("\tМаг \"%s\" наносит урон молнией \"%s\" в \"%s\" единиц урона\n", wizard.getName(), opponent.getName(), damage);

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
