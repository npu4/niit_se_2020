package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;

// Цепная молния - наносит урон, всем персонажам на сцене, кроме мага, который произносит заклинание.
public class ChainLighting extends Spell {
    public void cast(Magician mage, Character[] battlers){
        setNameOfSpell("Цепная молния");
        int amount = readingOfSpell(mage);
        for (Character i : battlers){
            if(i != null && ! i.equals(mage)){  // Сокращенное И
                i.setHealth(i.getHealth() - amount);
                System.out.println(i.getType() + " " +  i.getName() + " получил урон, равный " + amount + ". Теперь у него " +  i.getHealth() + " здоровья.");
            }
        }
    }
}