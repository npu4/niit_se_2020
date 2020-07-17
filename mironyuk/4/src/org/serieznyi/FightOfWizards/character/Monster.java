package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.util.FightHelper;

import java.util.Map;

/**
 *  - Монстры восстанавливают немного здоровья после своего действия
 */
final public class Monster extends Character {
    private static final double REGENERATION_FACTOR = 0.2;
    private final int damageSize;
    private int regenerationSize;

    public Monster(String name, int health, int damage) {
        super(name, health);

        regenerationSize = (int) (health * REGENERATION_FACTOR);

        damageSize = damage;
    }

    @Override
    public void action(Map<Integer, Character> opponents) {
        Character opponent = FightHelper.getRandomOpponentFrom(opponents);

        opponent.decreaseHealth(damageSize);

        System.out.printf("Монстр \"%s\" атакует \"%s\" на %s единиц урона\n", name, opponent.name, damageSize);

        regenerate();
    }

    private void regenerate() {
        if (regenerationSize <= 0) {
            return;
        }

        int healthBefore = getHealth();
        int newHealth = increaseHealth(regenerationSize);

        if (healthBefore != newHealth) {
            System.out.printf("\tМонстр \"%s\" восстановил свое здоровье на \"%s\". Теперь у него \"%s\" здоровья\n", getName(), regenerationSize, newHealth);

            regenerationSize--;
            System.out.printf("\tРегенерация у монстра \"%s\" ослабла\n", name);
        }
    }
}
