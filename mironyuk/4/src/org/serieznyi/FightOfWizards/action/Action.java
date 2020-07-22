package org.serieznyi.FightOfWizards.action;

public interface Action {
  Type getType();

  enum Type {
    DAMAGE,
    HEALING,
  }
}
