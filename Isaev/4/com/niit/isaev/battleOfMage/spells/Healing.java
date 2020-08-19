package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public class Healing extends Spell {
    private final static int HEAL = 30;

    public Healing() {
        super("Исцеление");
    }

    @Override
    public void cast(List<Character> allNotDead, Character executor, List<Character> allEnemies, List<Character> allNeighbour) {
        if (executor.getHealth() == executor.getDEFAULT_HEALTH()) {
            System.out.println("Здоровье персонажа " + executor.getName() + " полное.");
        } else {
            if (executor.getHealth() + HEAL > executor.getDEFAULT_HEALTH()) {
                executor.setHealth(100);
            } else {
                executor.setHealth(executor.getHealth() + HEAL);
            }
            System.out.println("Персонаж - " + executor.getName() + " вылечился на " + HEAL + ". Теперь его здоровье равно:" + executor.getHealth());
        }
    }


}
