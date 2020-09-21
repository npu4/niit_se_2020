package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;

public abstract class Spell {
    private static String nameOfSpell;
    public static final int numOfSpells = 7;

    public static void setNameOfSpell(String nameOfSpell) {
        Spell.nameOfSpell = nameOfSpell;
    }

    public abstract void cast(Magician mage, Character[] battlers);

    public void readingOfSpell(Magician mage) {
        System.out.println("Маг " + mage.getName() + " читает заклинание " + nameOfSpell);
    }
}