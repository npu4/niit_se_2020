package battle.spell;

import battle.characters.Character;
import battle.characters.Wizard;

public class ChainLight extends Spell {
    private final int ATTACK_DAMAGE = 3;

    @Override
    public void cast(Character[] characters, Wizard attacker) {
        System.out.println(attacker.getName() + " читает заклинание Цепная молния");
        for (Character ch : characters) {
            if (ch != null && ch != attacker) {
                ch.setHealth(ch.getHealth() - ATTACK_DAMAGE);
                System.out.printf("%s атакует %s и наносит %d урона\n",
                        attacker.getName(), ch.getName(), ATTACK_DAMAGE);
            }
        }
        System.out.println();
    }
}
