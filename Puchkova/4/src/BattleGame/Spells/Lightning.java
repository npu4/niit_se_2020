package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.annotations.XmlName;

import java.util.Random;

// Молния - наносит урон любому персонажу.
public class Lightning extends Spell {
    @XmlName(fieldName = "Название_заклинания")
    private static final String nameOfSpell = "Молния";

    public Lightning() {
        super(nameOfSpell);
    }

    public Character[] cast(Magician mage, Character[] battlers, int damage) {
        Character[] target = new Character[1];
        readingOfSpell(mage);
        int k;
        k = new Random().nextInt(10);
        while (battlers[k] == null) {
            k = new Random().nextInt(10);
        }
        target[0] = battlers[k].clone();
        battlers[k].setHealth(battlers[k].getHealth() - damage);
        System.out.println(battlers[k].getType() + " " + battlers[k].getName() + " получил урон, равный " + damage +
                ". Теперь у него " + battlers[k].getHealth() + " здоровья.");
        return target;
    }

    @Override
    public void castReplay(Magician mage, Character[] battlers, int damage) {
        readingOfSpell(mage);
        battlers[0].setHealth(battlers[0].getHealth() - damage);
        System.out.println(battlers[0].getType() + " " + battlers[0].getName() + " получил урон, равный " + damage +
                ". Теперь у него " + battlers[0].getHealth() + " здоровья.");
    }
}