package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.logging.Logger;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.Optional;

/**
 * Огненное касание - наносит урон персонажу, стоящему на соседней с магом позиции. Если на соседних
 * позициях персонажей нет - никому урон не наносится.
 */
public final class FireTouchSpell implements Spell {
  static final Logger LOGGER = Logger.create();

  /** Количество урона наносимое заклинанием */
  private final int damage;

  public FireTouchSpell(int damage) {
    Assert.greaterThan(damage, 1);
    this.damage = damage;
  }

  @Override
  public String getName() {
    return "Огненное касание";
  }

  @Override
  public String getDescription() {
    return "Наносит урон персонажу, стоящему на соседней с магом позиции.\n"
        + " Если на соседних позициях персонажей нет - никому урон не наносится. ";
  }

  @Override
  public void cast(Character wizard, Scene scene) {

    Optional<Character> opponent = scene.findNeighboredOpponentFor(wizard);

    if (opponent.isPresent()) {
      Character c = opponent.get();

      c.reactOnAction(CausingDamageAction.causeFireDamage(damage));

      LOGGER.takeDamageTo(wizard, this, c, damage);
    } else {
      LOGGER.debug("Рядом не оказалось противников и заклинания ничего не сделало");
    }
  }
}