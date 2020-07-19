package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

/**
 * Исцеление - добавляет очков здоровья магу, произнесшему заклинание. 
 */
final public class Healing extends Spell {
    /**
     * Значение до которого может ослабиться сила лечения
     */
    private final int minHealingStrength;

    /**
     * Текущая сила лечения заклинания
     */
    private int healingStrength;

    public Healing(int healingStrength) {
        super("Исцеление");

        Assert.greaterThan(healingStrength, 1);
        this.healingStrength = healingStrength;

        this.minHealingStrength = (int) (healingStrength * 0.5F);
    }

    @Override
    public void cast(Character wizard, Scene scene) {
        int healthBefore = wizard.getHealth();
        int newHealth = wizard.increaseHealth(healingStrength);

        if (healthBefore != newHealth) {
            System.out.printf("\tМаг \"%s\" исцелен на \"%s\". Теперь у него \"%s\" здоровья\n", wizard.getName(), healingStrength, newHealth);

            weakenSpell(wizard);
        }
    }

    /**
     * Уменьшаем силу заклинания, что бы маг не мог бесконечно себя лечить
     */
    private void weakenSpell(Character wizard)
    {
        if (healingStrength > minHealingStrength) {
            healingStrength-=2;

            System.out.printf("\tЗаклинание \"%s\" у мага \"%s\" ослабло\n", name, wizard.getName());
        }
    }
}
