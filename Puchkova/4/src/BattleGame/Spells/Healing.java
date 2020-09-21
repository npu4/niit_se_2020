package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;

import java.util.Random;

// Исцеление - добавляет очков здоровья магу, произнесшему заклинания
public class Healing extends Spell {
    public void cast(Magician mage, Character[] battlers){
        setNameOfSpell("Исцеление");
        int amount = new Random().nextInt(10) + 1;
        readingOfSpell(mage);
        mage.setHealth(mage.getHealth() + amount);
        System.out.println("Маг " + mage.getName() + " исцелён на " + amount + ". Теперь у него " + mage.getHealth() + " здоровья.");
    }
}
