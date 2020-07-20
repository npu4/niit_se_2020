package org.serieznyi.FightOfWizards.factory;

import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Functions;

import java.util.Set;

public class SpellBagFactory {
  private static final int DEFAULT_SIZE_OF_SPELLS_BAG = 3;

  private final Set<Spell> allowedSpells;

  public SpellBagFactory(Set<Spell> allowedSpells) {
    if (allowedSpells.size() == 0) {
      throw new IllegalArgumentException("Массив доступных заклинаний не может быть пустым");
    }

    this.allowedSpells = allowedSpells;
  }

  public Spell[] create() {
    return create(DEFAULT_SIZE_OF_SPELLS_BAG);
  }

  public Spell[] create(int count) {

    return allowedSpells.stream()
        .sorted(Functions::randomComparator)
        .limit(count)
        .toArray(Spell[]::new);
  }
}
