package org.serieznyi.FightOfWizards.action;

public interface Action {
    enum Type {
        DAMAGE,
        HEALING,
    }

    Type getType();
}
