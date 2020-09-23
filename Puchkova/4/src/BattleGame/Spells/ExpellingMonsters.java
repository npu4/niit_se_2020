package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.Monster;
import BattleGame.annotations.XmlName;

import static BattleGame.Scene.MAX_NUM_OF_BATTLERS;

// Изгнание монстров - наносит урон всем монстрам.
public class ExpellingMonsters extends Spell {
    @XmlName(fieldName = "Название_заклинания")
    private static final String nameOfSpell = "Цепная молния";

    public ExpellingMonsters() {
        super(nameOfSpell);
    }

    public Character[] cast(Magician mage, Character[] battlers, int damage) {
        Character[] target = new Character[MAX_NUM_OF_BATTLERS - 1];
        int count = 0;
        readingOfSpell(mage);
        for (Character battler : battlers) {
            if (battler instanceof Monster) {
                target[count++] = battler.clone();
                battler.setHealth(battler.getHealth() - damage);
                System.out.println("Монстр " + battler.getName() + " получил урон, равный " + damage
                        + ". Теперь у него " + battler.getHealth() + " здоровья.");
            }
        }
        return target;
    }

    @Override
    public void castReplay(Magician mage, Character[] battlers, int damage) {
        readingOfSpell(mage);
        for (Character battler : battlers) {
            if (battler != null)
            {
                battler.setHealth(battler.getHealth() - damage);
                System.out.println("Монстр " + battler.getName() + " получил урон, равный " + damage
                        + ". Теперь у него " + battler.getHealth() + " здоровья.");
            }
        }
    }
}
