package org.serieznyi.FightOfWizards.action;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

abstract public class BasicAction implements Action {
  private Character initiator;
  private List<Character> targets;

  protected BasicAction(Builder<?> builder) {

    this.initiator = builder.initiator;

    this.targets = new ArrayList<>(builder.targets);
  }

  public BasicAction() {

  }

  public Character getInitiator() {
    return initiator;
  }

  public Set<Character> getTargets() {
    return new HashSet<>(targets);
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
