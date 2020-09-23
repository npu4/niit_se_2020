package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.annotations.XmlName;

// Исцеление - добавляет очков здоровья магу, произнесшему заклинания
public class Healing extends Spell {
    @XmlName(fieldName = "Название_заклинания")
    private static final String nameOfSpell = "Исцеление";

    public Healing() {
        super(nameOfSpell);
    }

    public Character[] cast(Magician mage, Character[] battlers, int damage){
        Character[] target = new Character[1];
        target[0] = mage.clone();
        readingOfSpell(mage);
        target[0].setHealth(mage.getHealth() + damage);
        System.out.println("Маг " + target[0].getName() + " исцелён на " + damage + ". Теперь у него " + target[0].getHealth() + " здоровья.");
        return target;
    }

    @Override
    public void castReplay(Magician mage, Character[] battlers, int damage) {
        readingOfSpell(mage);
        battlers[0].setHealth(mage.getHealth() + damage);
        System.out.println("Маг " + battlers[0].getName() + " исцелён на " + damage + ". Теперь у него " + battlers[0].getHealth() + " здоровья.");
    }
}
