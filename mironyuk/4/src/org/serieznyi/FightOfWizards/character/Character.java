package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.util.Assert;

public abstract class Character {
    protected String name;

    protected int health;

    public Character(String name, int health) {
        Assert.requireNotEmptyString(name);
        this.name = name;

        Assert.greaterThan(health, 1);
        this.health = health;
    }

    public void action() {
//        "Маг <имя> читает заклинание <название заклинания>"
    }

    public String toString() {
        return name;
    }
}
