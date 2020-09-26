package BattleGame.Actions;

import BattleGame.Character;
import BattleGame.annotations.EnclosingTag;
import BattleGame.annotations.XmlName;
import BattleGame.annotations.XmlTypeName;

@EnclosingTag(tagName = "Действия")
@XmlTypeName(typeName = "Действие")
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
