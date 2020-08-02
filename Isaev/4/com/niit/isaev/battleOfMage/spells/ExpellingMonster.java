package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public class ExpellingMonster extends Spell {
    private final static int DAMAGE = 40;

    public ExpellingMonster() {
        super("Изгнание монстров");
    }

    @Override
    public void cast(List<Character> list, Character character) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && list.get(i).getClass().getSimpleName().equals("Monster")) {
                list.get(i).setHealth(list.get(i).getHealth() - DAMAGE);
                System.out.println("Монстр с именем " + list.get(i).getName() + " получил урон от изгнания монстров:" + DAMAGE);
            }
        }
    }

}
