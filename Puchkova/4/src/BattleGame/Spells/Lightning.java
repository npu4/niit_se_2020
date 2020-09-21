package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;

import java.util.Random;

// Молния - наносит урон любому персонажу.
public class Lightning extends Spell {
    public void cast(Magician mage, Character[] battlers){
        setNameOfSpell("Молния");
        int amount = new Random().nextInt(10) + 1;
        readingOfSpell(mage);
        int k;
        k = new Random().nextInt(10);
        while (battlers[k] == null)
        {
            k = new Random().nextInt(10);
        }
        battlers[k].setHealth(battlers[k].getHealth() - amount);
        System.out.println(battlers[k].getType() + " " +  battlers[k].getName() + " получил урон, равный " + amount + ". Теперь у него " +  battlers[k].getHealth() + " здоровья.");
    }
}