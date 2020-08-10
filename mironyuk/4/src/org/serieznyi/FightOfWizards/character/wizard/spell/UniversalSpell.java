package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.action.result.Result;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.logging.Logger;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Универсальное заклинание собирается с помощью builder и позволяет создать заклинание применимое к
 * группе противников
 */
public final class UniversalSpell implements Spell {
  static final Logger LOGGER = Logger.create();

  private final String name;
  private final String description;
  private final Number value;
  private final BiFunction<Character, Scene, Map<Integer, Character>> targetsFinder;
  private final Function<Character, Function<Character, Function<Number, Action>>> actionCreator;
  private final Function<Character, Function<Spell, Function<Set<Character>, Consumer<Number>>>> successMessage;

  private UniversalSpell(Builder builder) {
    name = builder.name;
    description = builder.description;
    value = builder.value;
    actionCreator = builder.actionCreator;
    targetsFinder = builder.targetsFinder;
    successMessage = builder.successMessage;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void cast(Character wizard, Scene scene) {
    Map<Integer, Character> opponents = targetsFinder.apply(wizard, scene);
    Set<Character> damagedOpponents = new HashSet<>();

    for (Map.Entry<Integer, Character> opponent : opponents.entrySet()) {
      Action action = actionCreator.apply(wizard).apply(opponent.getValue()).apply(value);
      Character character = opponent.getValue();

      Result result = character.reactOnAction(action);

      if (result.isSuccessful()) {
        damagedOpponents.add(character);
      }
    }

    if (null != successMessage && damagedOpponents.size() > 0) {
      successMessage.apply(wizard).apply(this).apply(damagedOpponents).accept(value);
    }

    if (damagedOpponents.size() == 0) {
      LOGGER.debug("Заклинание не подействовало");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UniversalSpell that = (UniversalSpell) o;
    return name.equals(that.name)
        && description.equals(that.description)
        && value.equals(that.value)
        && targetsFinder.equals(that.targetsFinder)
        && actionCreator.equals(that.actionCreator)
        && Objects.equals(successMessage, that.successMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, value, targetsFinder, actionCreator, successMessage);
  }

  public static class Builder {
    private String name;
    private String description;
    private Number value;
    private BiFunction<Character, Scene, Map<Integer, Character>> targetsFinder;
    private Function<Character, Function<Character, Function<Number, Action>>> actionCreator;
    private Function<Character, Function<Spell, Function<Set<Character>, Consumer<Number>>>>
        successMessage;

    private Builder() {}

    public Spell build() {
      Assert.requireNotEmptyString(name);
      Assert.requireNotEmptyString(description);
      Assert.requireNotNull(targetsFinder);
      Assert.requireNotNull(actionCreator);
      Assert.requireNotNull(value);

      return new UniversalSpell(this);
    }

    public Builder withName(String name) {
      this.name = name;

      return this;
    }

    public Builder withValue(Number value) {
      this.value = value;

      return this;
    }

    public Builder withDescription(String description) {
      this.description = description;

      return this;
    }

    public Builder withTargetsFinder(BiFunction<Character, Scene, Map<Integer, Character>> finder) {
      this.targetsFinder = finder;

      return this;
    }

    public Builder withActionCreator(Function<Character, Function<Character, Function<Number, Action>>> executor) {
      this.actionCreator = executor;

      return this;
    }

    public Builder withSuccessfulCallback(
        Function<Character, Function<Spell, Function<Set<Character>, Consumer<Number>>>> consumer) {
      this.successMessage = consumer;

      return this;
    }
  }
}
