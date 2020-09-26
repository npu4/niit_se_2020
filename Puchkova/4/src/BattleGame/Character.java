package BattleGame;

import BattleGame.annotations.EnclosingTag;
import BattleGame.annotations.XmlName;
import BattleGame.annotations.XmlTypeName;

import java.util.Arrays;

@EnclosingTag(tagName = "Персонажи")
@XmlTypeName(typeName = "Персонаж")
public abstract class Character {
    @XmlName(fieldName = "Позиция")
    private int position;
    @XmlName(fieldName = "Здоровье")
    private int health;
    @XmlName(fieldName = "Имя")
    private String name;
    @XmlName(fieldName = "Тип")
    private String type;

    Character[] target;

    Character(){
    }

    Character(int position, String name, String type, int health){
        this.position   =   position;
        this.health     =   health;
        this.name       =   name;
        this.type       =   type;
    }

    public abstract void attack(Character[] battlers, int damage);


    public void setPosition(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean isDead(){
        return getHealth() <= 0;
    }

    public abstract Character clone();

    public Character[] getTarget(){
        return target;
    }

    @Override
    public String toString() {
        return "Character{" +
                "position=" + position +
                ", health=" + health +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", target=" + Arrays.toString(target) +
                '}';
    }
}
