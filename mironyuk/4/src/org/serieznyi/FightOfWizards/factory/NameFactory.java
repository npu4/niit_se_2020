package org.serieznyi.FightOfWizards.factory;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.factory.name.NameRule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class NameFactory {
  private final List<NameRule> nameRules;

  private final Set<String> usedNames = new HashSet<>();

  public NameFactory(List<NameRule> nameRules) {
    this.nameRules = nameRules;
  }

  public String nextName(Character.Type nameForType) {

    ThreadLocalRandom random = ThreadLocalRandom.current();

    String selectedName = null;

    int attempts = 0;
    int maxAttempts = 100;

    do {
      attempts++;

      if (attempts > maxAttempts) {
        return randomName(nameForType);
      }

      int index = random.nextInt(0, nameRules.size());
      NameRule nameRule = nameRules.get(index);

      if (nameRule.getType() != nameForType) {
        continue;
      }

      String[] names = nameRule.getNames();
      index = random.nextInt(0, names.length);
      String name = names[index];

      String[] modifiers = nameRule.getModifiers();
      index = random.nextInt(0, modifiers.length);
      String modifier = modifiers[index];

      String potentialName = name + " " + modifier;

      if (isNameReserved(potentialName)) {
        continue;
      }

      selectedName = potentialName;

      reserveName(selectedName);
    } while (selectedName == null);

    return selectedName;
  }

  private String randomName(Character.Type nameForType) {
    String randomName = nameForType + " №" + usedNames.size();

    reserveName(randomName);

    return randomName;
  }

  public void reserveName(String name)
  {
    if (usedNames.contains(name)) {
      throw new RuntimeException("Имя уже занято: " + name);
    }

    usedNames.add(name);
  }

  public boolean isNameReserved(String name)
  {
    return usedNames.contains(name);
  }
}
