package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.util.Assert;

public abstract class Character {
    private final Health health;

    protected String name;

    public Character(String name, int health) {
        Assert.requireNotEmptyString(name);
        this.name = name;

        this.health = new Health(health);
    }

    public int getHealth() {
        return health.getHealth();
    }

    public abstract void action(Scene scene);

    public String toString() {
        return name;
    }

    public String getName()
    {
        return name;
    }

    public boolean isDead()
    {
        return health.isDead();
    }

    public void decreaseHealth(int value)
    {
        health.decreaseHealth(value);
    }

    public int increaseHealth(int value)
    {
        return health.increaseHealth(value);
    }

    public enum Type {
        MONSTER,
        WIZARD
    }

    private static class Health {
        protected int health;

        protected final int initialHealth;

        private Health(int health) {
            Assert.greaterThan(health, 1);
            this.health = initialHealth = health;
        }

        public void decreaseHealth(int health)
        {
            this.health -= health;
        }

        /**
         * @param health value to increase health
         * @return new health value
         */
        public int increaseHealth(int health)
        {
            if (isHealthLowerInitialHealth()) {
                this.health += health;
            }

            return this.health;
        }

        private boolean isHealthLowerInitialHealth() {
            return this.health < initialHealth;
        }

        public int getHealth()
        {
            return health;
        }

        public boolean isDead()
        {
            return health <= 0;
        }
    }
}
