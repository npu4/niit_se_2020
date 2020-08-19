package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;
import com.niit.isaev.battleOfMage.characters.Monster;

import java.util.List;

public class ExpellingMonster extends Spell {
    private final static int DAMAGE = 40;

    public ExpellingMonster() {
        super("Изгнание монстров");
    }

    @Override
    public void cast(List<Character> allNotDead, Character character, List<Character> allEnemies, List<Character> allNeighbour) {
        for (int i = 0; i < allNotDead.size(); i++) {
            if (allNotDead.get(i) instanceof Monster) {
                allNotDead.get(i).setHealth(allNotDead.get(i).getHealth() - DAMAGE);
                System.out.println("Монстр с именем " + allNotDead.get(i).getName() + " получил урон от изгнания монстров:" + DAMAGE);
            }
        }
    }
}
