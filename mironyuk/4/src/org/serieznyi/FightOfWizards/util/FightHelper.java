package org.serieznyi.FightOfWizards.util;

import org.serieznyi.FightOfWizards.character.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

final public class FightHelper {
    public static Character getRandomOpponentFrom(Map<Integer, Character> opponents) {
        // TODO выбирать ближайшего противника
        // TODO выбирать противника и сражаться только с ним

        List<Character> opponentsList = new ArrayList<>(opponents.values());
        Character opponent = null;
        int countAttempt = 0;
        do {
            int potentialOpponentKey = ThreadLocalRandom.current().nextInt(0, opponentsList.size());

            try {
                opponent = opponentsList.get(potentialOpponentKey);
            } catch (IndexOutOfBoundsException e) {
                countAttempt++;
            }

            if (countAttempt > 10) {
                throw new RuntimeException("Что-то пошло не так");
            }
        } while (null == opponent);

        return opponent;
    }
}
