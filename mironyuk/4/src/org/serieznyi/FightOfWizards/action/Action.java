package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.HashSet;
import java.util.Set;

abstract public class Action {
  private final Character aggressor;
  private final Set<Character> targets;

  abstract Type getType();

  protected Action(Builder<?> builder) {

    this.aggressor = builder.aggressor;

    this.targets = builder.targets;
  }

  public Character getAggressor() {
    return aggressor;
  }

  public Set<Character> getTargets() {
    return targets;
  }

  enum Type {
    DAMAGE,
    HEALING,
  }

  /**
   *
   * @param <T>
   * @see <a href="https://www.artima.com/weblogs/viewpost.jsp?thread=133275">Curiously Recurring Generic Pattern</a>
   */
  public static class Builder <T extends Builder<T>> {
    Character aggressor;

    Set<Character> targets = new HashSet<>();

    protected Builder() {
    }

    public T withAggressor(Character aggressor) {
      this.aggressor = aggressor;

      return (T) this;
    }

    public T addTarget(Character target) {
      targets.add(target);

      return (T) this;
    }

    protected void check()
    {
      Assert.requireNotNull(aggressor, "Укажите агрессора");
      Assert.requireNotEmptyCollection(targets, "Укажите цели");
    }
  }
}
