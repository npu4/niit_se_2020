package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.annotations.XmlName;

import static BattleGame.Scene.MAX_NUM_OF_BATTLERS;

// Мигрень - наносит урон всем магам.
public class Migraine extends Spell {
    @XmlName(fieldName = "Название_заклинания")
    private static final String nameOfSpell = "Мигрень";

    public Migraine() {
        super(nameOfSpell);
    }

    public Character[] cast(Magician mage, Character[] battlers, int damage) {
        Character[] target = new Character[MAX_NUM_OF_BATTLERS];
        int count = 0;
        readingOfSpell(mage);
        for (Character character : battlers) {
            if (character instanceof Magician) {
                target[count++] = character.clone();
                character.setHealth(character.getHealth() - damage);
                System.out.println("Маг " + character.getName() + " получил урон, равный " + damage
                        + ". Теперь у него " + character.getHealth() + " здоровья.");
            }
        }
        return target;
    }

    @Override
    public void castReplay(Magician mage, Character[] battlers, int damage) {
        readingOfSpell(mage);
        for (Character character : battlers) {
            if (character != null) {
                character.setHealth(character.getHealth() - damage);
                System.out.println("Маг " + character.getName() + " получил урон, равный " + damage
                        + ". Теперь у него " + character.getHealth() + " здоровья.");
            }
        }
    }
}
