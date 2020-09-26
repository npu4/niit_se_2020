package BattleGame;

import BattleGame.Spells.Spell;
import BattleGame.annotations.XmlIgnore;
import BattleGame.annotations.XmlTypeName;

import java.util.Arrays;
import java.util.Random;

@XmlTypeName(typeName = "Маг")
public class Magician extends Character {
    private static final String type = "Маг";
    public static final int SPELL_BOOK_LENGTH = 3;
    @XmlIgnore
    Spell spellUsed;
    @XmlIgnore
    Spell[] bookOfSpells;

    public Magician(){
    }

    Magician(int position, String name, int health, Spell[] spells){
        super(position, name, type, health);
        if(spells.length > SPELL_BOOK_LENGTH) {
            System.out.println("У магов не может быть больше 3 заклинаний. Из предложенных заклинаний у мага " + getName() + " будут первые 3");
        }
        bookOfSpells = new Spell[spells.length];
        System.arraycopy(spells, 0, bookOfSpells, 0, spells.length);
    }

    public Spell getSpellUsed() {
        return spellUsed;
    }

    public Character[] getTarget() {
        return target;
    }

    public void attack(Character[] battlers, int damage){
        int numOfSpell = new Random().nextInt(bookOfSpells.length);
        spellUsed = bookOfSpells[numOfSpell];
        this.target = spellUsed.cast(this, battlers, damage);
    }

    public void attack(Character[] target, Spell spell, int damage){
        spellUsed = spell;
        spellUsed.castReplay(this, target, damage);
    }

    public Spell[] getBookOfSpells() {
        return bookOfSpells;
    }

    public Magician clone() {
        Magician magician = new Magician(this.getPosition(), this.getName(), this.getHealth(), this.getBookOfSpells());
        magician.bookOfSpells = this.bookOfSpells.clone();
        return magician;
    }

    @Override
    public String toString() {
        return "Magician{" +
                "position=" + getPosition() +
                ", health=" + getHealth() +
                ", name='" + getName() + '\'' +
                ", type='" + type + '\'' +
                "spellUsed=" + spellUsed +
                ", bookOfSpells=" + Arrays.toString(bookOfSpells) +
                ", target=" + Arrays.toString(target) +
                '}';
    }
}