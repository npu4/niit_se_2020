package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

public final class Healing implements Spell {
  private static final int MIN_HEALING_STRENGTH = 1;
  private static final int HEALING_STRENGTH_WEAKEN_STEP = 2;
  /** Текущая сила лечения заклинания */
  private int healingStrength;

  public Healing(int healingStrength) {
    Assert.greaterThan(healingStrength, 1);
    this.healingStrength = healingStrength;
  }

  @Override
  public String getName() {
    return "Исцеление";
  }

  @Override
  public String getDescription() {
    return "Добавляет очков здоровья магу, произнесшему заклинание";
  }

  @Override
  public void cast(Character wizard, Scene scene) {
    int healthBefore = wizard.getHealth();
    int newHealth = wizard.increaseHealth(healingStrength);

    if (healthBefore != newHealth) {
      System.out.printf(
          "\tМаг \"%s\" исцелен на \"%s\". Теперь у него \"%s\" здоровья\n",
          wizard.getName(), healingStrength, newHealth);

      weakenSpell(wizard);
    }
  }

  /** Уменьшаем силу заклинания, что бы маг не мог бесконечно себя лечить */
  private void weakenSpell(Character wizard) {
    if (healingStrength - HEALING_STRENGTH_WEAKEN_STEP > MIN_HEALING_STRENGTH) {
      healingStrength -= HEALING_STRENGTH_WEAKEN_STEP;

      System.out.printf("\tЗаклинание \"%s\" у мага \"%s\" ослабло\n", getName(), wizard.getName());
    }
  }
}
