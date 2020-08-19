package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public class FireWall extends Spell {
    private static final int DAMAGE = 25;

    public FireWall() {
        super("Стена огня");
    }

    @Override
    public void cast(List<Character> allNotDead, Character executor, List<Character> allEnemies, List<Character> allNeighbour) {
        for (Character chars : allNotDead) {
            if (allNotDead.indexOf(chars) % 2 == 0) {
                chars.setHealth(chars.getHealth() - DAMAGE);
                System.out.println("Персонаж - " + chars.getName() + " получает урон от стены огня:" + DAMAGE);
            }
        }
    }
}


