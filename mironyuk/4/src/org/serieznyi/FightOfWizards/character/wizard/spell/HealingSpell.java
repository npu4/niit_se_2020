package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.HealingAction;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.logging.Logger;
import org.serieznyi.FightOfWizards.util.Assert;

public final class HealingSpell implements Spell {
  private static final Logger LOGGER = Logger.create();

  private static final int MIN_HEALING_STRENGTH = 1;
  private static final int HEALING_STRENGTH_WEAKEN_STEP = 2;
  /** Текущая сила лечения заклинания */
  private int healingStrength;

  public HealingSpell(int healingStrength) {
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
    if (wizard.reactOnAction(HealingAction.of(healingStrength))) {
      LOGGER.healing(wizard, healingStrength, wizard.getHealth());

      weakenSpell(wizard);
    } else {
      LOGGER.debug("Заклинание не подействовало");
    }
  }

  /** Уменьшаем силу заклинания, что бы маг не мог бесконечно себя лечить */
  private void weakenSpell(Character wizard) {
    if (healingStrength - HEALING_STRENGTH_WEAKEN_STEP > MIN_HEALING_STRENGTH) {
      healingStrength -= HEALING_STRENGTH_WEAKEN_STEP;

      LOGGER.spellWeaken(this, wizard);
    }
  }
}
