package battle.spell;

import battle.characters.Character;
import battle.characters.Monster;
import battle.characters.Wizard;

public class MonsterPurge extends Spell {
    private final int ATTACK_DAMAGE = 4;

    @Override
    public String cast(Character[] characters, Wizard attacker) {
        StringBuilder action = new StringBuilder();
        action.append(attacker.getName()).append(" читает заклинание Молния\n");

        for (Character ch : characters) {
            if (ch instanceof Monster) {
                ch.setHealth(ch.getHealth() - ATTACK_DAMAGE);
                action.append(String.format("%s атакует %s и наносит %d урона\n",
                        attacker.getName(), ch.getName(), ATTACK_DAMAGE));
            }
        }
        return action.toString();
    }
}
