package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;

import java.util.Random;

// Цепная молния - наносит урон, всем персонажам на сцене, кроме мага, который произносит заклинание.
public class ChainLighting extends Spell {
    public void cast(Magician mage, Character[] battlers){
        setNameOfSpell("Цепная молния");
        int amount = new Random().nextInt(10) + 1;
        readingOfSpell(mage);
        for (Character character : battlers){
            if(character != null && ! character.equals(mage)){  // Сокращенное И
                character.setHealth(character.getHealth() - amount);
                System.out.println(character.getType() + " " +  character.getName() + " получил урон, равный " + amount + ". Теперь у него " +  character.getHealth() + " здоровья.");
            }
        }
    }
}