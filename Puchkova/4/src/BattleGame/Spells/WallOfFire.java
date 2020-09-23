package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.annotations.XmlName;

import static BattleGame.Scene.MAX_NUM_OF_BATTLERS;

// Стена огня - наносит урон всем персонажам на четных позициях.
public class WallOfFire extends Spell {
    @XmlName(fieldName = "Название_заклинания")
    private static final String nameOfSpell = "Стена огня";

    public WallOfFire() {
        super(nameOfSpell);
    }

    public Character[] cast(Magician mage, Character[] battlers, int damage) {
        Character[] target = new Character[MAX_NUM_OF_BATTLERS / 2 + 1];
        int count = 0;
        readingOfSpell(mage);
        for (int i = 0; i < 10; i = i + 2) {
            if (battlers[i] != null) {  // Сокращенное И
                target[count++] = battlers[i].clone();
                battlers[i].setHealth(battlers[i].getHealth() - damage);
                System.out.println(battlers[i].getType() + " " + battlers[i].getName() + " получил урон, равный " + damage
                        + ". Теперь у него " + battlers[i].getHealth() + " здоровья.");
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
                System.out.println(character.getType() + " " + character.getName() + " получил урон, равный " + damage
                        + ". Теперь у него " + character.getHealth() + " здоровья.");
            }
        }
    }
}