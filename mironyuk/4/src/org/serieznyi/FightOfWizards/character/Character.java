package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.util.Assert;

import java.util.Map;

public abstract class Character {
    protected String name;

    protected int health;

    public Character(String name, int health) {
        Assert.requireNotEmptyString(name);
        this.name = name;

        Assert.greaterThan(health, 1);
        this.health = health;
    }

    public abstract void action(final Map<Integer, Character> opponents);

    public String toString() {
        return name;
    }

    public String getName()
    {
        return name;
    }

    protected void takeDamage(int damage)
    {
        health -= damage;
    }

    public boolean isDead()
    {
        return health <= 0;
    }
}
