package battle.spell;

import battle.characters.Character;
import battle.characters.Wizard;

public class Firewall extends Spell {
    private final int ATTACK_DAMAGE = 4;

    @Override
    public String cast(Character[] characters, Wizard attacker) {
        StringBuilder action = new StringBuilder();
        action.append(attacker.getName()).append(" читает заклинание Стена огня\n");
        for (int targetPosition = 0; targetPosition < characters.length; targetPosition += 2) {
            if (characters[targetPosition] != null) {
                characters[targetPosition].setHealth(characters[targetPosition].getHealth() - ATTACK_DAMAGE);
                action.append(String.format("%s атакует %s и наносит %d урона\n",
                        attacker.getName(), characters[targetPosition].getName(), ATTACK_DAMAGE));
            }
        }
        return action.toString();
    }
}
