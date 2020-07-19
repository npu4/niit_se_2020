package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.Optional;

/**
 * Огненное касание - наносит урон персонажу, стоящему на соседней с магом позиции.
 * Если на соседних позициях персонажей нет - никому урон не наносится. 
 */
final public class FireTouch extends Spell {

    /**
     * Количество урона наносимое заклинанием
     */
    private int damage;

    /**
     * Максимальное значение урона, до которого может усилиться заклинание
     */
    private final int maxDamage;

    public FireTouch(int damage) {
        super("Огненное касание");

        Assert.greaterThan(damage, 1);
        this.damage = damage;

        maxDamage = (int) (damage * 1.5F);
    }

    @Override
    public void cast(Character wizard, Scene scene) {

        Optional<Character> opponent = scene.findNeighboredOpponentFor(wizard);

        if (opponent.isPresent()) {
            Character c = opponent.get();

            c.increaseHealth(damage);
            System.out.printf("\t%s наносит урон по \"%s\" в размере \"%s\" единиц.\n", wizard.getName(), c.getName(), damage);

            strengthenSpell(wizard);
        } else {
            System.out.println("\tРадом не оказалось противников и заклинания ничего не сделало");
        }
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
