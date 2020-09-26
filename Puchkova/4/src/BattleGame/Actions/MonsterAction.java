package BattleGame.Actions;

import BattleGame.Character;
import BattleGame.Monster;
import BattleGame.annotations.XmlName;
import BattleGame.annotations.XmlTypeName;

@XmlTypeName(typeName = "Ход_монстра")
public class MonsterAction extends Action{
    @XmlName(fieldName = "Цель")
    Character target;

    public MonsterAction() {}

    public MonsterAction(Monster monster, int damage) {
        this.character = monster;
        this.damage = damage;
    }

    void action(Character[] battlers){
        character.attack(battlers, damage);
        try {
            target = character.getTarget()[0].clone();
        } catch (NullPointerException e) {
            target = null;
        }
    }

    Character[] replay(){
        ((Monster)character).attack(target, damage);
        return new Character[]{target};
    }

    @Override
    public String toString() {
        return "MonsterAction{" +
                "target=" + target +
                ", character=" + character +
                ", damage=" + damage +
                '}';
    }
}