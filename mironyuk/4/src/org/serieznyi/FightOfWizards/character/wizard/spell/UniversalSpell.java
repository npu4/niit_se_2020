package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.action.DummyAction;
import org.serieznyi.FightOfWizards.action.result.MessageResult;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;
import org.serieznyi.serialization.serializer.annotation.SerializeIgnoreField;

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
  private String name;
  @SerializeIgnoreField
  private String description;
  @SerializeIgnoreField
  private Number value;
  @SerializeIgnoreField
  private BiFunction<Character, Scene, Map<Integer, Character>> targetsFinder;
  @SerializeIgnoreField
  private Function<Character, Function<Set<Character>, Function<Number, Action>>> actionCreator;
  @SerializeIgnoreField
  private Function<Character, Function<Spell, Function<Set<Character>, Consumer<Number>>>> successMessage;

  private UniversalSpell() {}

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
  public Action cast(Character wizard, Scene scene) {
    Map<Integer, Character> opponents = targetsFinder.apply(wizard, scene);

    if (opponents.isEmpty()) {
      return new DummyAction(wizard, new MessageResult("Похоже мы не нанесли ни кому урона"));
    }

    return actionCreator.apply(wizard).apply(new HashSet<>(opponents.values())).apply(value);
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
    private Function<Character, Function<Set<Character>, Function<Number, Action>>> actionCreator;
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

    public Builder withActionCreator(Function<Character, Function<Set<Character>, Function<Number, Action>>> executor) {
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
