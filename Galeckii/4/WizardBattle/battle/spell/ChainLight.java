package battle.spell;

import battle.characters.Character;
import battle.characters.Wizard;

public class ChainLight extends Spell {
    private final int ATTACK_DAMAGE = 3;

    @Override
    public String cast(Character[] characters, Wizard attacker) {
        StringBuilder action = new StringBuilder();
        action.append(attacker.getName()).append(" читает заклинание Цепная молния\n");
        for (Character ch : characters) {
            if (ch != null && ch != attacker) {
                ch.setHealth(ch.getHealth() - ATTACK_DAMAGE);
                action.append(String.format("%s атакует %s и наносит %d урона\n",
                        attacker.getName(), ch.getName(), ATTACK_DAMAGE));
            }
        }
        return action.toString();
    }
}
