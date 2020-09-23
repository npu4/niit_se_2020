package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.annotations.XmlName;

import static BattleGame.Scene.MAX_NUM_OF_BATTLERS;

// Огненное касание - наносит урон персонажу, стоящему на соседней с магом позиции.
public class FieryTouch extends Spell {
    @XmlName(fieldName = "Название_заклинания")
    private static final String nameOfSpell = "Огненное касание";

    public FieryTouch() {
        super(nameOfSpell);
    }

    public Character[] cast(Magician mage, Character[] battlers, int damage) {
        Character[] target = new Character[1];
        readingOfSpell(mage);
        if (0 < mage.getPosition() && battlers[mage.getPosition() - 1] != null) {
            target[0] = battlers[mage.getPosition() - 1].clone();
            battlers[mage.getPosition() - 1].setHealth(battlers[mage.getPosition() - 1].getHealth() - damage);
            System.out.println(battlers[mage.getPosition() - 1].getType() + " " + battlers[mage.getPosition() - 1].getName()
                    + " получил урон, равный " + damage + ". Теперь у него " + battlers[mage.getPosition() - 1].getHealth()
                    + " здоровья.");
        } else if (mage.getPosition() + 1 < MAX_NUM_OF_BATTLERS && battlers[mage.getPosition() + 1] != null) {
            target[0] = battlers[mage.getPosition() + 1].clone();
            battlers[mage.getPosition() + 1].setHealth(battlers[mage.getPosition() + 1].getHealth() - damage);
            System.out.println(battlers[mage.getPosition() + 1].getType() + " " + battlers[mage.getPosition() + 1].getName()
                    + " получил урон, равный " + damage + ". Теперь у него " + battlers[mage.getPosition() + 1].getHealth()
                    + " здоровья.");
        }
        return target;
    }

    @Override
    public void castReplay(Magician mage, Character[] battlers, int damage) {
        readingOfSpell(mage);
        if(battlers[0] != null) {
            battlers[0].setHealth(battlers[0].getHealth() - damage);
            System.out.println(battlers[0].getType() + " " + battlers[0].getName() + " получил урон, равный " + damage
                    + ". Теперь у него " + battlers[0].getHealth() + " здоровья.");
        }
    }
}