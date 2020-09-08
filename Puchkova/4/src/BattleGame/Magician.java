package BattleGame;

import BattleGame.Spells.Spell;

import java.util.Random;

public class Magician extends Character {
    public static final int SPELL_BOOK_LENGTH = 3;
    Spell[] bookOfSpells;

    Magician(int position, String name, int health, Spell[] spells){
        super(position, name, "Маг", health);
        if(spells.length > SPELL_BOOK_LENGTH) {
            System.out.println("У магов не может быть больше 3 заклинаний. Из предложенных заклинаний у мага " + getName() + " будут первые 3");
        }
        bookOfSpells = new Spell[spells.length];
        System.arraycopy(spells, 0, bookOfSpells, 0, spells.length);
    }

    @Override
    void attack(Character[] battlers){
        int numOfSpell = new Random().nextInt(bookOfSpells.length);
        bookOfSpells[numOfSpell].cast(this, battlers);
    }
}