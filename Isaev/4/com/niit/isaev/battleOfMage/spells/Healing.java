package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public class Healing extends Spell {
    private final static int HEAL = 30;

    public Healing() {
        super("Исцеление");
    }

    @Override
    public void cast(List<Character> list, Character character) {
        if (character.getHealth() == character.getDEFAULT_HEALTH()) {
            System.out.println("Здоровье персонажа " + character.getName() + " полное.");
        } else {
            if (character.getHealth() + HEAL > character.getDEFAULT_HEALTH()) {
                character.setHealth(100);
            } else {
                character.setHealth(character.getHealth() + HEAL);
            }
            System.out.println("Персонаж - " + character.getName() + " вылечился на " + HEAL + ". Теперь его здоровье равно:" + character.getHealth());
        }
    }


}
