package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public class FireTouch extends Spell {
    private static final int DAMAGE = 35;


    public FireTouch() {
        super("Огненное прикосновение");
    }

    @Override
    public void cast(List<Character> allNotDead, Character executor, List<Character> allEnemies, List<Character> allNeighbour) {
        Character first = null;
        if (allNeighbour.size() > 0) {
            first = allNeighbour.get(0);
        }
        Character second = null;
        if (allNeighbour.size() > 1) {
            second = allNeighbour.get(1);
        }
        if (first != null) {
            first.setHealth(first.getHealth() - DAMAGE);
            System.out.println("Персонаж " + executor.getName() + " получает урон от огненного прикосновения:" + DAMAGE);
        } else {
            System.out.println("На позиции слева никого нет.");
        }
        if (second != null) {
            second.setHealth(second.getHealth() - DAMAGE);
            System.out.println("Персонаж " + executor.getName() + " получает урон от огненного прикосновения:" + DAMAGE);
        } else {
            System.out.println("На позиции справа никого нет.");
        }

    }

}
