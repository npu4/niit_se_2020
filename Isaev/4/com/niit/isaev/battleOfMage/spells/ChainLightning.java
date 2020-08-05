package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public class ChainLightning extends Spell {
    private final static int DAMAGE = 20;

    public ChainLightning() {
        super("Цепная молния");
    }

    @Override
    public void cast(List<Character> allNotDead, Character executor, List<Character> allEnemies, List<Character> allNeighbour) {
        for (Character chars : allEnemies) {
            chars.setHealth(chars.getHealth() - DAMAGE);
            System.out.println("Персонаж - " + chars.getName() + " получает урон от цепной молнии:" + DAMAGE);
        }
    }

}

