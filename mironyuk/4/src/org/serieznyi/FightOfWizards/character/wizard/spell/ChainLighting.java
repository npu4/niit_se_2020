package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ChainLighting implements Spell {
  /** Количество урона наносимое заклинанием */
  private final int damage;

  public ChainLighting(int damage) {
    Assert.greaterThan(damage, 1);
    this.damage = damage;
  }

  @Override
  public String getName() {
    return "Цепная молния";
  }

  @Override
  public String getDescription() {
    return "Наносит урон, всем персонажам на сцене, кроме мага, который произносит заклинание";
  }

  @Override
  public void cast(Character wizard, Scene scene) {

    Map<Integer, Character> opponents = scene.getOpponentsFor(wizard);

    List<String> damagedOpponentNames = new ArrayList<>();

    for (Character character : opponents.values()) {
      character.decreaseHealth(damage);
      damagedOpponentNames.add(character.getName());
    }

    String opponentNames = String.join(", ", damagedOpponentNames);

    System.out.printf(
        "\t%s ударяет по \"%s\". Каждый получает \"%s\" единиц урона.\n",
        getName(), opponentNames, damage);
  }
}
