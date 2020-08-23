package org.serieznyi.FightOfWizards.logging;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.logging.handler.OutputHandler;

import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public final class Logger {
  private static Logger instance;

  Handler handler = new OutputHandler();

  private Logger() {}

  public static Logger create() {

    if (null == instance) {
      instance = new Logger();
    }

    return instance;
  }

  private static String toNamesListAsString(Set<Character> characters) {
    return String.join(", ", characters.stream().map(Character::toString).toArray(String[]::new));
  }

  public void setHandler(Handler handler) {
    this.handler = handler;
  }

  public void characterDead(Character character) {
    handler.dangerous(format("%s \"%s\" убит", character.getType().translate(), character.getName()));
  }

  public void readSpell(Character character, Spell spell) {
    String message =
        format(
            "%s \"%s\" читает заклинание \"%s\"",
            character.getType().translate(), character.getName(), spell.getName());

    handler.info(message);
  }

  public void takenDamage(
      Character character, Spell spell, Set<Character> characters, int damage) {
    String message =
        format(
            "%s \"%s\" нанес урон \"%s\" с помощью заклинания \"%s\". Каждый получает \"%s\" единиц урона.",
            character.getType().translate(),
            character.getName(),
            toNamesListAsString(characters),
            spell.getName(),
            damage);

    handler.warning(message);
  }

  public void takenDamage(Character character, Spell spell, Character opponent, int damage) {
    String message =
        format(
            "%s \"%s\" нанес урон персонажу \"%s\" в размере \"%s\" единиц с помощью заклинания \"%s\"",
            character.getType().translate(), character.getName(), opponent.getName(), damage, spell.getName());

    handler.warning(message);
  }

  public void takenDamage(Character character, Character opponent, int damage) {
    String message =
        format(
            "%s \"%s\" нанес \"%s\" единиц урона персонажу \"%s\"",
            character.getType().translate(), character.getName(), damage, opponent.getName());

    handler.warning(message);
  }

  public void takenDamage(Character character, Set<Character> opponents, int damage) {
    String characterNames = opponents.stream().map(Character::getName).reduce("", (a, b) -> b + ", " + a);

    String message =
        format(
            "%s \"%s\" нанес \"%s\" единиц урона персонажам \"%s\"",
            character.getType().translate(), character.getName(), damage, characterNames);

    handler.warning(message);
  }

  public void info(String s, Object... args) {
    handler.info(format(s, args));
  }

  public void newline() {
    handler.info("");
  }

  public void characterAttack(Character aggressor, Set<Character> targets) {
    if (targets.size() == 1) {
      characterAttack(aggressor, targets.iterator().next());
      return;
    }

    String names = targets.stream().map(Character::getName).reduce("", (a, b) -> b + ", " + a);

    String message =
        format(
            "%s \"%s\" атакует \"%s\"", aggressor.getType().translate(), aggressor.getName(), names);

    handler.info(message);
  }

  public void characterAttack(Character aggressor, Character target) {
    String message =
        format(
            "%s \"%s\" атакует \"%s\"", aggressor.getType().translate(), aggressor.getName(), target.getName());

    handler.info(message);
  }

  public void debug(String s) {
    handler.debug(s);
  }

  public void healing(Character character, int healingStrength, int newHealth) {
    String message =
        format(
            "%s \"%s\" исцелен на \"%s\". Теперь у него %s единиц здоровья",
            character.getType().translate(), character.getName(), healingStrength, newHealth);

    handler.success(message);
  }

  public void spellWeaken(Spell spell, Character character) {
    String message =
        format("Заклинание \"%s\" у мага \"%s\" ослабло", spell.getName(), character.getName());

    handler.debug(message);
  }

  public void winner(Character winner) {
    handler.success("\n-------------------------------------------------------------------");
    handler.success(String.format("На поле боя остался только \"%s\"", winner.getName()));
    handler.success("-------------------------------------------------------------------");
  }

  public void charactersOnBattlefield(List<Character> characters) {
    String characterNames = characters.stream().map(Character::getName).reduce("", (a, b) -> b + ", " + a);

    info("На поле боя находятся: %s", characterNames);
  }

  public void miss(Character character) {
    String message = format("Персонаж \"%s\" избежал урона", character.getName());

    handler.info(message);
  }
}
