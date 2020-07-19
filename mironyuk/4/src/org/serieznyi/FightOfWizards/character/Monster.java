package org.serieznyi.FightOfWizards.character;

import org.serieznyi.FightOfWizards.Scene;

/**
 *  - Монстры восстанавливают немного здоровья после своего действия
 */
final public class Monster extends Character {
    private final int damageSize;

    public Monster(String name, int health, int damage) {
        super(name, health);

        damageSize = damage;
    }

    @Override
    public void action(Scene scene) {
        Character opponent = scene.getRandomOpponentFor(this);

        opponent.decreaseHealth(damageSize);

        System.out.printf("Монстр \"%s\" атакует \"%s\" на %s единиц урона\n", name, opponent.name, damageSize);
    }
}
