package BattleGame.Actions;

import BattleGame.Character;
import BattleGame.Monster;
import BattleGame.annotations.XmlName;

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
}