package BattleGame.Actions;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.Spells.Spell;
import BattleGame.annotations.XmlName;
import BattleGame.annotations.XmlTypeName;

import java.util.Arrays;

@XmlTypeName(typeName = "Ход_мага")
public class MagicianAction extends Action{
    @XmlName(fieldName = "Заклинание_атаки")
    Spell spell;
    @XmlName(fieldName = "Цели")
    Character[] target;

    public MagicianAction(){}

    public MagicianAction(Magician magician, Spell spell, int damage) {
        this.character = magician;
        this.spell = spell;
        this.damage = damage;
    }

    void action(Character[] battlers){
        character.attack(battlers, damage);
        try {
            target = character.getTarget();
            spell = ((Magician)character).getSpellUsed();
        } catch (NullPointerException e) {
            target = null;
        }
    }

    Character[] replay(){
        ((Magician)character).attack(target, spell, damage);
        return target;
    }

    @Override
    public String toString() {
        return "MagicianAction{" +
                "spell=" + spell +
                ", target=" + Arrays.toString(target) +
                ", character=" + character +
                ", damage=" + damage +
                '}';
    }
}
