package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.annotations.XmlName;

import static BattleGame.Scene.MAX_NUM_OF_BATTLERS;

// Цепная молния - наносит урон, всем персонажам на сцене, кроме мага, который произносит заклинание.
public class ChainLighting extends Spell {
    @XmlName(fieldName = "Название_заклинания")
    private static final String nameOfSpell = "Цепная молния";

    public ChainLighting() {
        super(nameOfSpell);
    }

    public Character[] cast(Magician mage, Character[] battlers, int damage) {
        Character[] target = new Character[MAX_NUM_OF_BATTLERS - 1];
        int count = 0;
        readingOfSpell(mage);
        for (Character character : battlers) {
            if (character != null && !character.equals(mage)) {  // Сокращенное И
                target[count++] = character.clone();
                character.setHealth(character.getHealth() - damage);
                System.out.println(character.getType() + " " + character.getName() + " получил урон, равный " + damage
                        + ". Теперь у него " + character.getHealth() + " здоровья.");
            }
        }
        return target;
    }

    public void castReplay(Magician mage, Character[] battlers, int damage) {
        readingOfSpell(mage);
        for (Character character : battlers) {
            if(character != null){
                character.setHealth(character.getHealth() - damage);
                System.out.println(character.getType() + " " + character.getName() + " получил урон, равный " + damage
                        + ". Теперь у него " + character.getHealth() + " здоровья.");
            }
        }
    }
}