package BattleGame.Actions;

import BattleGame.Character;
import BattleGame.annotations.XmlName;

public abstract class Action {
    @XmlName(fieldName = "Атакующий")
    Character character;
    @XmlName(fieldName = "Урон")
    int damage;

    public Character getCharacter() {
        return character;
    }

    abstract void action(Character[] battlers);
    abstract Character[] replay();
}
