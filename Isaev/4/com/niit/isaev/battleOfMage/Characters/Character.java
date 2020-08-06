package com.niit.isaev.battleOfMage.characters;

import java.util.List;

public abstract class Character {

    static int setterName = 0;
    private int health;
    private String name;
    private final int DEFAULT_HEALTH = 100;

    public Character(String name) {
        this.name = name;
        this.health = DEFAULT_HEALTH;
    }

    public Character(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public Character() {
        this.health = DEFAULT_HEALTH;
    }

    public int getDEFAULT_HEALTH() {
        return DEFAULT_HEALTH;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String[] names) {
        this.name = names[setterName];
        setterName++;
    }

    public void attack(List<Character> list) {

    }

    public void isDead(List<Character> list, Character character) {
        if (character.getHealth() <= 0) {
            list.set(list.indexOf(character), null);
            System.out.println(character.getName() + " мёртв. Мы уносим его с поля битвы!");
        }
    }
}
