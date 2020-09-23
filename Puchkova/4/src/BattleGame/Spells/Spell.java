package BattleGame.Spells;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.annotations.EnclosingTag;
import BattleGame.annotations.XmlName;
import BattleGame.annotations.XmlTypeName;

@EnclosingTag(tagName = "Заклинания")
@XmlTypeName(typeName = "Заклинание")
public abstract class Spell {
    @XmlName(fieldName = "Название_заклинания")
    private final String nameOfSpell;
    public static final int numOfSpells = 7;

    public Spell(String nameOfSpell) {
        this.nameOfSpell = nameOfSpell;
    }

    public String getNameOfSpell() {
        return nameOfSpell;
    }

    public abstract Character[] cast(Magician mage, Character[] battlers, int damage);
    public abstract void castReplay(Magician mage, Character[] battlers, int damage);

    public void readingOfSpell(Magician mage) {
        System.out.println("Маг " + mage.getName() + " читает заклинание " + getNameOfSpell());
    }
}