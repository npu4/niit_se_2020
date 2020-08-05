package com.niit.isaev.battleOfMage.characters;

import com.niit.isaev.battleOfMage.spells.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mage extends Character {
    private static final int NUMBER_OF_SPELLS = 3;
    private static final int ALL_SPELLS = 6;

    List<Spell> spells = new ArrayList<>();
    static String[] names = {"Чейн", "Бром", "Фродо", "Шепард", "Коллектор", "Миранда", "Герт", "Плотва", "Геральт", "Маша"};

    public Mage(int health, String name) {
        super(health, name);
    }

    public Mage(String name) {
        super(name);
    }

    public Mage() {
        this.setName(names);
        getSpells();
    }


    Spell spellsRandom() {
        int numberOfSpell = new Random().nextInt(ALL_SPELLS + 1);
        switch (numberOfSpell) {
            case 0:
                return new Healing();
            case 1:
                return new ChainLightning();
            case 2:
                return new ExpellingMonster();
            case 3:
                return new FireTouch();
            case 4:
                return new FireWall();
            case 5:
                return new Lightning();
            case 6:
                return new Migraine();
        }
        return null;
    }

    void getSpells() {
        for (int i = 0; i < NUMBER_OF_SPELLS; i++) {
            spells.add(spellsRandom());
        }
    }

    @Override
    public void attack(List<Character> list) {
        int target = new Random().nextInt(10);
        if (list.get(target) == null) {
            target = new Random().nextInt(10);
        } else {
            Spell spell = spells.get(new Random().nextInt(spells.size()));
            System.out.println("Маг - " + this.getName() + " кастует заклинание - " + spell.getName());
            if (spell.getName().equals("Исцеление")) {
                spell.cast(list, this);
            } else {
                spell.cast(list, list.get(target));
                list.get(target).isDead(list, list.get(target));
            }


        }
    }
}
