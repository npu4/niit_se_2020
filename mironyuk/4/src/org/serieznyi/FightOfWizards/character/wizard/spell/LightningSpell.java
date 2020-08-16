package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

public final class LightningSpell implements Spell {
  /** Количество урона наносимое заклинанием */
  private int damage;

  private LightningSpell() {}

  public LightningSpell(int damage) {
    Assert.greaterThan(damage, 1);
    this.damage = damage;
  }

  @Override
  public String getName() {
    return "Молния";
  }

  @Override
  public String getDescription() {
    return "Наносит урон любому персонажу";
  }

  @Override
  public Action cast(Character wizard, Scene scene) {
    Character opponent = scene.getRandomOpponentFor(wizard);

    return CausingDamageAction
            .builder()
            .withInitiator(wizard)
            .addTarget(opponent)
            .causeLightingDamage(damage)
            .build();
  }
}
