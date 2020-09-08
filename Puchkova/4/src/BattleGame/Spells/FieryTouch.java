package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;

// Огненное касание - наносит урон персонажу, стоящему на соседней с магом позиции.
public class FieryTouch extends Spell {
    public void cast(Magician mage, Character[] battlers){
        setNameOfSpell("Огненное касание");
        int amount = readingOfSpell(mage);
        if(battlers[mage.getPosition()+1] == null) {
            if (battlers[mage.getPosition() - 1] == null) {
                System.out.println("Никто урон не получил.");
            } else {
                battlers[mage.getPosition() - 1].setHealth(battlers[mage.getPosition() - 1].getHealth() - amount);
                System.out.println("Персонаж " + battlers[mage.getPosition() - 1].getName() + " получил урон, равный " + amount + ". Теперь у него " + battlers[mage.getPosition() - 1].getHealth() + " здоровья.");
            }
        }
        else{
            battlers[mage.getPosition() + 1].setHealth(battlers[mage.getPosition() + 1].getHealth() - amount);
            System.out.println(battlers[mage.getPosition() + 1].getType() + " " +  battlers[mage.getPosition() + 1].getName() + " получил урон, равный " + amount + ". Теперь у него " + battlers[mage.getPosition() + 1].getHealth() + " здоровья.");
        }
    }
}