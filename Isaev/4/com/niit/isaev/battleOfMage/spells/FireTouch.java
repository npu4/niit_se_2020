package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public class FireTouch extends Spell {
    private static final int DAMAGE = 35;


    public FireTouch() {
        super("Огненное прикосновение");
    }

    @Override
    public void cast(List<Character> list, Character character) {
        int position = list.indexOf(character);
        Character first;
        Character second;
        if (list.get(Math.abs(position - 1)) != null) {
            first = list.get(Math.abs(position - 1));
            first.setHealth(first.getHealth() - DAMAGE);
            System.out.println("Персонаж " + character.getName() + " получает урон от огненного прикосновения:" + DAMAGE);
        } else {
            System.out.println("На позиции слева никого нет.");
        }

        if (list.get((position + 1) % 10) != null) {
            second = list.get((position + 1) % 10);
            second.setHealth(second.getHealth() - DAMAGE);
            System.out.println("Персонаж " + character.getName() + " получает урон от огненного прикосновения:" + DAMAGE);
        } else {
            System.out.println("На позиции справа никого нет.");
        }

    }

}
