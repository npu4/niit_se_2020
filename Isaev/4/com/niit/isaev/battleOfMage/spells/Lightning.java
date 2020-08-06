package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public class Lightning extends Spell {
    private final static int DAMAGE = 40;

    public Lightning() {
        super("Молния");
    }

    @Override
    public void cast(List<Character> list, Character character) {
        character.setHealth(character.getHealth() - DAMAGE);
        System.out.println("В персонажа " + character.getName() + " ударяет молния, нанося ему урон:" + DAMAGE);
    }
}
