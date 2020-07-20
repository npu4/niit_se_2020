package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public final class UniversalSpell implements Spell {
  private final String name;
  private final String description;
  private final Number value;
  private final BiFunction<Character, Scene, Map<Integer, Character>> targetsFinder;
  private final BiFunction<Character, Number, Action> actionCreator;
  private final Function<Character, Function<Spell, Function<Set<Character>, Consumer<Number>>>> successMessage;

  private UniversalSpell(Builder builder) {
    name = builder.name;
    description = builder.description;
    value = builder.value;
    actionCreator = builder.actionCreator;
    targetsFinder = builder.targetsFinder;
    successMessage = builder.successMessage;
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

    for (Map.Entry<Integer, Character> opponent: opponents.entrySet()) {
      Action action = actionCreator.apply(opponent.getValue(), value);
      Character character = opponent.getValue();

      if (character.reactOnAction(action)) {
        damagedOpponents.add(character);
      }
    }

    if (null != successMessage && damagedOpponents.size() > 0) {
      successMessage.apply(wizard).apply(this).apply(damagedOpponents).accept(value);
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String name;
    private String description;
    private Number value;
    private BiFunction<Character, Scene, Map<Integer, Character>> targetsFinder;
    private BiFunction<Character, Number, Action> actionCreator;
    private Function<Character, Function<Spell, Function<Set<Character>, Consumer<Number>>>> successMessage;

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

    public Builder withActionCreator(BiFunction<Character, Number, Action> executor) {
      this.actionCreator = executor;

      return this;
    }

    public Builder withSuccessfulCallback(Function<Character, Function<Spell, Function<Set<Character>, Consumer<Number>>>> consumer) {
      this.successMessage = consumer;

      return this;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UniversalSpell that = (UniversalSpell) o;
    return name.equals(that.name) &&
            description.equals(that.description) &&
            value.equals(that.value) &&
            targetsFinder.equals(that.targetsFinder) &&
            actionCreator.equals(that.actionCreator) &&
            Objects.equals(successMessage, that.successMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, value, targetsFinder, actionCreator, successMessage);
  }
}
