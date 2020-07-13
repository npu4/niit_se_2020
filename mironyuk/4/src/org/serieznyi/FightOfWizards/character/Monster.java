package org.serieznyi.FightOfWizards.character;

import java.util.ArrayList;
import java.util.List;
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

        List<Character> opponentsList = new ArrayList<>(opponents.values());
        Character opponent = null;
        int countAttempt = 0;
        do {
            int potentialOpponentKey = ThreadLocalRandom.current().nextInt(0, opponentsList.size() + 1);

            try {
                opponent = opponentsList.get(potentialOpponentKey);
            } catch (IndexOutOfBoundsException e) {
                countAttempt++;
            }

            if (countAttempt > 5) {
                throw new RuntimeException("Что-то пошло не так");
            }
        } while (null == opponent);

        return opponent;
    }
}
