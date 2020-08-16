package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.action.HealingAction;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.logging.Logger;
import org.serieznyi.FightOfWizards.util.Assert;
import org.serieznyi.serialization.serializer.annotation.Serialize;
import org.serieznyi.serialization.serializer.annotation.SerializeIgnoreField;

@Serialize
public final class HealingSpell implements Spell {
  @SerializeIgnoreField
  private static final Logger LOGGER = Logger.create();

  @SerializeIgnoreField
  private static final int MIN_HEALING_STRENGTH = 1;

  @SerializeIgnoreField
  private static final int HEALING_STRENGTH_WEAKEN_STEP = 2;
  /** Текущая сила лечения заклинания */
  private int healingStrength;

  private HealingSpell()
  {

  }

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
  public Action cast(Character wizard, Scene scene) {
    return HealingAction
            .builder()
            .withInitiator(wizard)
            .addTarget(wizard)
            .withValue(healingStrength)
            .build();
  }

  /** Уменьшаем силу заклинания, что бы маг не мог бесконечно себя лечить */
  private void weakenSpell(Character wizard) {
    if (healingStrength - HEALING_STRENGTH_WEAKEN_STEP > MIN_HEALING_STRENGTH) {
      healingStrength -= HEALING_STRENGTH_WEAKEN_STEP;

      LOGGER.spellWeaken(this, wizard);
    }
  }
}
