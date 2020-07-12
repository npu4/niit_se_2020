package org.serieznyi.FightOfWizards.character;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

final public class Monster extends Character {
    private final int damageSize;

    public Monster(String name, int health, int damage) {
        super(name, health);

        damageSize = damage;
    }

    @Override
    public void action(Map<Integer, Character> opponents) {
        Character opponent = getRandomOpponentFrom(opponents);

        opponent.takeDamage(damageSize);

    System.out.println(
        String.format(
            "Монстр \"%s\" атакует \"%s\" на %s единиц урона", name, opponent.name, damageSize));
    }

    private Character getRandomOpponentFrom(Map<Integer, Character> opponents) {
        // TODO выбирать ближайшего противника
        // TODO выбирать противника и сражаться только с ним

        Character opponent = null;
        do {
            int potentialOpponentKey = ThreadLocalRandom.current().nextInt(0, opponents.size());

            if (opponents.containsKey(potentialOpponentKey)) {
                opponent = opponents.get(potentialOpponentKey);
            }
        } while (null == opponent);

        return opponent;
    }
}
