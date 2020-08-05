package com.niit.isaev.battleOfMage.characters;

import java.util.List;
import java.util.Random;

public class Monster extends Character {
    static int DAMAGE = 1 + new Random().nextInt(20);

    public Monster(int health, String name) {
        super(health, name);
    }

    public Monster(String name) {
        super(name);
    }

    public Monster() {
        this.setName(names);
    }

    String[] names = {"Вервульф", "Стрыга", "Утопец", "Жнец", "Ктулху", "Мутант", "Собака", "Волк", "Корь", "Ведьма"};

    @Override
    public void attack(List<Character> list) {
        int target = new Random().nextInt(10);
        if (list.get(target) == null) {
            target = new Random().nextInt(10);
        } else {
            list.get(target).setHealth(list.get(target).getHealth() - DAMAGE);
            list.get(target).isDead(list, list.get(target));

        }
    }
}
