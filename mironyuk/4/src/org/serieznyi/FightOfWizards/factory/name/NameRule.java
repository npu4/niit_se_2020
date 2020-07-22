package org.serieznyi.FightOfWizards.factory.name;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.util.Assert;

public class NameRule {
  private final Character.Type type;
  private final String[] names;
  private final String[] modifiers;

  public NameRule(Character.Type type, String[] names, String[] modifiers) {
    this.type = type;

    Assert.requireNotEmptyArray(names);
    this.names = names;

    Assert.requireNotEmptyArray(modifiers);
    this.modifiers = modifiers;
  }

  public Character.Type getType() {
    return type;
  }

  public String[] getNames() {
    return names;
  }

  public String[] getModifiers() {
    return modifiers;
  }
}
