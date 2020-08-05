package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public class ChainLightning extends Spell {
    private final static int DAMAGE = 20;

    public ChainLightning() {
        super("Цепная молния");
    }

    @Override
    public void cast(List<Character> list, Character character) {
        for (Character chars : list) {
            if (list.get(list.indexOf(chars)) != null && !character.getName().equals(chars.getName())) {
                chars.setHealth(chars.getHealth() - DAMAGE);
                System.out.println("Персонаж - " + chars.getName() + " получает урон от цепной молнии:" + DAMAGE);
            }
        }

    }
}
