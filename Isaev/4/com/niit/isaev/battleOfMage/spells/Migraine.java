package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;
import com.niit.isaev.battleOfMage.characters.Mage;

import java.util.List;

public class Migraine extends Spell {

    private final static int DAMAGE = 40;

    public Migraine() {
        super("Мигрень");
    }

    @Override
    public void cast(List<Character> allNotDead, Character executor, List<Character> allEnemies, List<Character> allNeighbour) {
        for (Character chars : allNotDead) {
            if (chars instanceof Mage) {
                chars.setHealth(chars.getHealth() - DAMAGE);
                System.out.println("Монстр с именем " + chars.getName() + " получил урон от мигрени:" + DAMAGE);
            }
        }
    }

}
