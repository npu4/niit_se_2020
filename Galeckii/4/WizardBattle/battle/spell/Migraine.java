package battle.spell;

import battle.characters.Character;
import battle.characters.Wizard;

public class Migraine extends Spell {
    private final int ATTACK_DAMAGE = 4;

    @Override
    public void cast(Character[] characters, Wizard attacker) {
        System.out.println(attacker.getName() + " читает заклинание Мигрень");
        for (Character ch : characters) {
            if (ch instanceof Wizard) {
                ch.setHealth(ch.getHealth() - ATTACK_DAMAGE);
                System.out.printf("%s атакует %s и наносит %d урона\n", attacker.getName(), ch.getName(), ATTACK_DAMAGE);
                isTargetDead(characters, ch.getPosition());
            }
        }
        System.out.println();
    }

}
