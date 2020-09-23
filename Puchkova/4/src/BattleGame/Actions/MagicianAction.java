package BattleGame.Actions;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.Spells.Spell;
import BattleGame.annotations.XmlName;
import BattleGame.annotations.XmlTypeName;

@XmlTypeName(typeName = "Ход_мага")
public class MagicianAction extends Action{
    @XmlName(fieldName = "Заклинание")
    Spell spell;
    @XmlName(fieldName = "Цель")
    Character[] target;

    MagicianAction(){}

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
}
