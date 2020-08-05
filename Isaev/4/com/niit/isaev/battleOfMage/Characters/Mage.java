package com.niit.isaev.battleOfMage.characters;

import com.niit.isaev.battleOfMage.spells.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Mage extends Character {
    private static final int NUMBER_OF_SPELLS = 3;

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
        getRandomSpells();
    }

    void getRandomSpells() {
        List<Spell> allSpells = new ArrayList<>();
        allSpells.add(new Healing());
        allSpells.add(new ChainLightning());
        allSpells.add(new ExpellingMonster());
        allSpells.add(new FireTouch());
        allSpells.add(new FireWall());
        allSpells.add(new Lightning());
        allSpells.add(new Migraine());
        Collections.shuffle(allSpells);
        for (int i = 0; i < NUMBER_OF_SPELLS; i++) {
            spells.add(allSpells.get(i));
        }
    }

    @Override
    public void attack(List<Character> allList, List<Character> allNotDead, List<Character> allEnemies, List<Character> allNeighbour) {
        Character target = allNotDead.get(new Random().nextInt(allNotDead.size()));
        Spell spell = spells.get(new Random().nextInt(spells.size()));
        System.out.println("Маг - " + this.getName() + " кастует заклинание - " + spell.getName());
        spell.cast(allNotDead, this, allEnemies, allNeighbour);
        target.isDead(allList, target);

    }

}
