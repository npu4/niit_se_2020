package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.action.CausingDamage;
import org.serieznyi.FightOfWizards.action.Healing;
import org.serieznyi.FightOfWizards.character.wizard.Spell;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * - Заклинания наносящие урон постепенно усиливаются - Заклинания восстанавливающие жизни после
 * каждого успешного применения ослабевают
 */
public final class Wizard extends Character {
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
  public void action(Scene scene) {
    Spell spell = takeSomeSpell();

    System.out.printf("Маг \"%s\" читает заклинание \"%s\"\n", name, spell.getName());

    spell.cast(this, scene);
  }

  @Override
  public boolean reactOnAction(Action action) {
    if (action instanceof CausingDamage) {
      CausingDamage causingDamage = (CausingDamage) action;

      decreaseHealth(causingDamage.getDamage());

      return true;
    } else if (action instanceof Healing) {
      Healing healing = (Healing) action;

      increaseHealth(healing.getValue());

      return true;
    }

    return false;
  }
}
