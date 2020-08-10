package battle.spell;

import battle.characters.Character;
import battle.characters.Wizard;

import java.util.Random;

public class Lightning extends Spell {
    private final int ATTACK_DAMAGE = 5;

    @Override
    public String cast(Character[] characters, Wizard attacker) {
        StringBuilder action = new StringBuilder();
        action.append(attacker.getName()).append(" читает заклинание Молния\n");
        int targetPosition;
        while (true) {
            targetPosition = new Random().nextInt(characters.length);
            if (characters[targetPosition] != null && characters[targetPosition] != attacker) {
                characters[targetPosition].setHealth(characters[targetPosition].getHealth() - ATTACK_DAMAGE);
                action.append(String.format("%s атакует %s и наносит %d урона\n",
                        attacker.getName(), characters[targetPosition].getName(), ATTACK_DAMAGE));
                break;
            }
        }

        return action.toString();
    }
}
