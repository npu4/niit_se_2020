package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.FightOfWizards.action.HealingAction;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.logging.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * - Может использовать заклинания
 * - Магический урон наносит только половину урона
 */
public final class Wizard extends Character {
  static final Logger LOGGER = Logger.create();

  private static final int SPELLS_BAG_SIZE = 3;

  private final List<Spell> spells;

  public Wizard(String name, int health, Spell[] spells) {
    super(Type.WIZARD, name, health);

    if (spells.length > SPELLS_BAG_SIZE) {
      throw new IllegalArgumentException("Истинный волшебник использует не более 3х заклинаний");
    }

    this.spells = Arrays.asList(spells);
  }

  public Spell takeSomeSpell() {
    int index = ThreadLocalRandom.current().nextInt(0, spells.size());

    return spells.get(index);
  }

  @Override
  public void applyAction(Scene scene) {
    Spell spell = takeSomeSpell();

    LOGGER.readSpell(this, spell);

    spell.cast(this, scene);
  }

  @Override
  public boolean reactOnHealingAction(HealingAction action) {
    int oldHealth = getHealth();
    int newHealth = increaseHealth(action.getValue());

    return newHealth != oldHealth;
  }

  @Override
  public boolean reactOnCausingDamageAction(CausingDamageAction action) {
    int oldHealth = getHealth();
    int damage = action.getDamage();

    // Магический урон наносит только половину урона
    if (action.getDamageType() == CausingDamageAction.Type.MAGICAL) {
      damage /= 2;
    }

    int newHealth = decreaseHealth(damage);

    return oldHealth != newHealth;
  }
}
