package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.HashSet;
import java.util.Set;

abstract public class BasicAction implements Action {
  private final Character initiator;
  private final Set<Character> targets;

  protected BasicAction(Builder<?> builder) {

    this.initiator = builder.initiator;

    this.targets = builder.targets;
  }

  public Character getInitiator() {
    return initiator;
  }

  public Set<Character> getTargets() {
    return targets;
  }

  enum Type {
    DAMAGE,
    HEALING,
    DUMMY,
  }

  /**
   *
   * @param <T>
   * @see <a href="https://www.artima.com/weblogs/viewpost.jsp?thread=133275">Curiously Recurring Generic Pattern</a>
   */
  public static class Builder <T extends Builder<T>> {
    Character initiator;

    Set<Character> targets = new HashSet<>();

    protected Builder() {
    }

    public T withInitiator(Character initiator) {
      this.initiator = initiator;

      return (T) this;
    }

    public T addTarget(Character target) {
      targets.add(target);

      return (T) this;
    }

    public T addTargets(Set<Character> o) {
      targets.addAll(o);

      return (T) this;
    }

    protected void check()
    {
      Assert.requireNotNull(initiator, "Укажите инциатора действия");
      Assert.requireNotEmptyCollection(targets, "Укажите цели");
    }
  }
}
