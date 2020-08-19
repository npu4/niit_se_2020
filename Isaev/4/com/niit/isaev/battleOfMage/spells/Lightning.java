package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;
import java.util.Random;

public class Lightning extends Spell {
    private final static int DAMAGE = 40;

    public Lightning() {
        super("Молния");
    }

    @Override
    public void cast(List<Character> allNotDead, Character character, List<Character> allEnemies, List<Character> allNeighbour) {
        Character target = allEnemies.get(new Random().nextInt(allEnemies.size()));
        target.setHealth(target.getHealth() - DAMAGE);
        System.out.println("В персонажа " + target.getName() + " ударяет молния, нанося ему урон:" + DAMAGE);
    }
}
