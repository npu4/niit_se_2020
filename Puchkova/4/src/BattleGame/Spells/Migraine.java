package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;

// Мигрень - наносит урон всем магам.
public class Migraine extends Spell {
    public void cast(Magician mage, Character[] battlers) {
        setNameOfSpell("Мигрень");
        int amount = readingOfSpell(mage);
        for (Character i : battlers) {
            if (i instanceof Magician) {
                i.setHealth(i.getHealth() - amount);
                System.out.println("Маг " + i.getName() + " получил урон, равный " + amount + ". Теперь у него " + i.getHealth() + " здоровья.");
            }
        }
    }
}
