package BattleGame;

import BattleGame.annotations.XmlName;
import BattleGame.annotations.XmlTypeName;

import java.util.Random;

import static BattleGame.Scene.MAX_NUM_OF_BATTLERS;


@XmlTypeName(typeName = "Монстр")
public class Monster extends Character {
    private static final String type = "Монстр";
    @XmlName(fieldName = "Урон")
    private final int damage;

    public Monster() {
        damage = 0;
    }

    public Monster(int position, String name, int health, int damage) {
        super(position, name, type, health);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void attack(Character[] battlers, int damage){
        int k = new Random().nextInt(MAX_NUM_OF_BATTLERS);
        while (battlers[k] == null)
        {
            k = new Random().nextInt(MAX_NUM_OF_BATTLERS);
        }
        target = new Character[1];
        target [0] = battlers[k].clone();
        battlers[k].setHealth(battlers[k].getHealth() - damage);
        System.out.println("Монстр " + getName() + " атакует " + battlers[k].getName() + " на " + damage + " единиц урона.");
        System.out.println("Теперь у " + battlers[k].getName() + " " + battlers[k].getHealth() + " здоровья.");
    }

    public void attack(Character target, int damage){
        if(target != null){
            this.target = new Character[1];
            this.target [0] = target.clone();
            target.setHealth(target.getHealth() - damage);
            System.out.println("Монстр " + getName() + " атакует " + target.getName() + " на " + damage + " единиц урона.");
            System.out.println("Теперь у " + target.getName() + " " + target.getHealth() + " здоровья.");
        }
    }

    public Monster clone() {
        return new Monster(this.getPosition(), this.getName(), this.getHealth(), this.getDamage());
    }
}
