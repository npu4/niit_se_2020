package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;

import java.util.Random;

public abstract class Spell {
    private static String nameOfSpell;

    public static void setNameOfSpell(String nameOfSpell) {
        Spell.nameOfSpell = nameOfSpell;
    }

    public abstract void cast(Magician mage, Character[] battlers);

    public int readingOfSpell(Magician mage) {
        System.out.println("Маг " + mage.getName() + " читает заклинание " + nameOfSpell);
        return(new Random().nextInt(10) + 1);
    }
}