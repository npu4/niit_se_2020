package battle;

import battle.characters.Character;
import battle.characters.Monster;
import battle.characters.Wizard;

import java.util.Random;

public class Scene {
    private final int NUMBER_OF_PLAYERS = 10;
    private Character[] positions = new Character[NUMBER_OF_PLAYERS];

    public void createScene() {
        for (int i = 0; i < positions.length; i++) {
            int random = new Random().nextInt(3);
            if (random == 1) {
                positions[i] = new Monster(i, 10, "Monster_" + i);
            } else if (random == 2) {
                positions[i] = new Wizard(i, 10, "Wizard_" + i);
            } else {
                positions[i] = null;
            }
        }
    }

    public Character[] getPositions() {
        return positions;
    }
}
