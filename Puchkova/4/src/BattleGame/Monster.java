package BattleGame;

import java.util.Random;

public class Monster extends Character {
    private final int damage;     // Урон, который наносит монстр

    Monster(int position, String name, int health, int damage){
        super(position, name, "Монстр", health);
        this.damage = damage;
    }

    @Override
    void attack(Character[] battlers){
        int k;
        k = new Random().nextInt(10);
        while (battlers[k] == null)
        {
            k = new Random().nextInt(10);
        }
        battlers[k].setHealth(battlers[k].getHealth() - damage);
        System.out.println("Монстр " + getName() + " атакует " + battlers[k].getName() + " на " + damage + " единиц урона.");
        System.out.println("Теперь у " + battlers[k].getName() + " " + battlers[k].getHealth() + " здоровья.");
    }
}
