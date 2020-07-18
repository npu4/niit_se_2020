package battle.spell;

import battle.characters.Character;
import battle.characters.Wizard;

public class Firewall extends Spell {
    private final int ATTACK_DAMAGE = 4;

    @Override
    public void cast(Character[] characters, Wizard attacker) {
        System.out.println(attacker.getName() + " читает заклинание Стена огня");
        for (int targetPosition = 0; targetPosition < characters.length; targetPosition += 2) {
            if (characters[targetPosition] != null) {
                characters[targetPosition].setHealth(characters[targetPosition].getHealth() - ATTACK_DAMAGE);
                System.out.printf("%s атакует %s и наносит %d урона\n",
                        attacker.getName(), characters[targetPosition].getName(), ATTACK_DAMAGE);
                isTargetDead(characters, targetPosition);
            }
        }
        System.out.println();
    }
}
