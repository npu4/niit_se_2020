package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.Monster;

// Изгнание монстров - наносит урон всем монстрам.
public class ExpellingMonsters extends Spell {
    public void cast(Magician mage, Character[] battlers) {
        setNameOfSpell("Цепная молния");
        int amount = readingOfSpell(mage);
        for (Character battler : battlers) {
            if (battler instanceof Monster) {
                battler.setHealth(battler.getHealth() - amount);
                System.out.println("Монстр " +  battler.getName() + " получил урон, равный " + amount + ". Теперь у него " + battler.getHealth() + " здоровья.");
            }
        }
    }
}
