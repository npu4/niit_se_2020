package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public class Migraine extends Spell {

    private final static int DAMAGE = 40;

    public Migraine() {
        super("Мигрень");
    }

    @Override
    public void cast(List<Character> list, Character character) {
        for (Character chars : list) {
            if (list.get(list.indexOf(chars)) != null && chars.getClass().getSimpleName().equals("Mage")) {
                chars.setHealth(chars.getHealth() - DAMAGE);
                System.out.println("Монстр с именем " + chars.getName() + " получил урон от мигрени:" + DAMAGE);
            }
        }
    }

}
