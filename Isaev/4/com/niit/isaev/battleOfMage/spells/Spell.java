package com.niit.isaev.battleOfMage.spells;

import com.niit.isaev.battleOfMage.characters.Character;

import java.util.List;

public abstract class Spell {
    public String name;

    public Spell(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void cast(List<Character> allNotDead, Character executor, List<Character> allEnemies, List<Character> allNeighbour) {


    }
}
