package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.FightOfWizards.action.HealingAction;
import org.serieznyi.FightOfWizards.action.SpellActionDecorator;
import org.serieznyi.FightOfWizards.action.result.CausingDamageResult;
import org.serieznyi.FightOfWizards.action.result.HealingResult;
import org.serieznyi.FightOfWizards.action.result.Result;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.serialization.serializer.annotation.Serialize;
import org.serieznyi.serialization.serializer.annotation.SerializeIgnoreField;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * - Может использовать заклинания
 * - Магический урон наносит только половину урона
 */
@Serialize
public final class Wizard extends Character {

  @SerializeIgnoreField
  private static final int SPELLS_BAG_SIZE = 3;

  @SerializeIgnoreField
  private List<Spell> spells;

  private Wizard() {
    super();
  }

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
  public Action produceAction(Scene scene) {
    Spell spell = takeSomeSpell();

    Action spellAction = spell.cast(this, scene);

    return new SpellActionDecorator(spell, this, spellAction);
  }

  @Override
  public Result reactOnHealingAction(HealingAction action) {
    int oldHealth = getHealth();
    int newHealth = increaseHealth(action.getValue());

    return new HealingResult(
            newHealth != oldHealth,
            newHealth - oldHealth,
            newHealth
    );
  }

  @Override
  public Result reactOnCausingDamageAction(CausingDamageAction action) {
    int oldHealth = getHealth();
    int damage = action.getDamage();

    // Магический урон наносит только половину урона
    if (action.getDamageType() == CausingDamageAction.Type.MAGICAL) {
      damage /= 2;
    }

    int newHealth = decreaseHealth(damage);

    return new CausingDamageResult(
            oldHealth != newHealth,
            damage,
            action.getDamage(),
            newHealth
    );
  }
}
