package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;

import java.util.Random;

// Мигрень - наносит урон всем магам.
public class Migraine extends Spell {
    public void cast(Magician mage, Character[] battlers) {
        setNameOfSpell("Мигрень");
        int amount = new Random().nextInt(10) + 1;
        readingOfSpell(mage);
        for (Character character : battlers) {
            if (character instanceof Magician) {
                character.setHealth(character.getHealth() - amount);
                System.out.println("Маг " + character.getName() + " получил урон, равный " + amount + ". Теперь у него " + character.getHealth() + " здоровья.");
            }
        }
    }
}
