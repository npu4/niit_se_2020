package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;

import java.util.Random;

// Стена огня - наносит урон всем персонажам на четных позициях.
public class WallOfFire extends Spell {
    public void cast(Magician mage, Character[] battlers){
        setNameOfSpell("Стена огня");
        int amount = new Random().nextInt(10) + 1;
        readingOfSpell(mage);
        for (int i = 0; i < 10; i = i+2){
            if(battlers[i] != null){  // Сокращенное И
                battlers[i].setHealth(battlers[i].getHealth() - amount);
                System.out.println(battlers[i].getType() + " " +  battlers[i].getName() + " получил урон, равный " + amount + ". Теперь у него " +  battlers[i].getHealth() + " здоровья.");
            }
        }
    }
}