package battle.spell;

import battle.characters.Character;
import battle.characters.Wizard;

import java.util.Random;

public class Lightning extends Spell {
    private final int ATTACK_DAMAGE = 5;

    @Override
    public void cast(Character[] characters, Wizard attacker) {

        int targetPosition;
        while (true) {
            targetPosition = new Random().nextInt(characters.length);
            if (characters[targetPosition] != null && characters[targetPosition] != attacker) {
                System.out.println(attacker.getName() + " читает заклинание Молния");
                characters[targetPosition].setHealth(characters[targetPosition].getHealth() - ATTACK_DAMAGE);
                System.out.printf("%s атакует %s и наносит %d урона\n\n", attacker.getName(), characters[targetPosition].getName(), ATTACK_DAMAGE);
                break;
            }
        }

        isTargetDead(characters, targetPosition);
    }
}
