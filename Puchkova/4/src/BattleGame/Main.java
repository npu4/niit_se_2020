package BattleGame;

import BattleGame.Spells.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Spell s1 = new Healing();
        Spell s2 = new Lightning();
        Spell s3 = new ChainLighting();
        Spell s4 = new WallOfFire();
        Spell s5 = new FieryTouch();
        Spell s6 = new ExpellingMonsters();
        Spell s7 = new Migraine();
        Spell[] for1mage = {s1, s2, s3};
        Spell[] for2mage = {s2, s4, s6};
        Spell[] for3mage = {s3, s5, s7};
        Spell[] for4mage = {s1, s7};

        /* 1 СЦЕНА
        Magician mage1 = new Magician(1, "Бернар", 30, for1mage);
        Magician mage2 = new Magician(3, "Даниэль", 25, for2mage);
        Magician mage3 = new Magician(6, "Фредерик", 20, for3mage);
        Magician mage4 = new Magician(9, "Тьерри", 30, for4mage);

        Monster monster1 = new Monster(2, "Алонсо", 30, new Random().nextInt(10)+1);
        Monster monster2 = new Monster(4, "Карлос", 25, new Random().nextInt(10)+1);
        Monster monster3 = new Monster(8, "Мануэль", 35, new Random().nextInt(10)+1);

        Character[] battlers = {mage1, mage2, mage3, mage4, monster1, monster2, monster3};
        */

        /* 2 СЦЕНА
        Magician mage1 = new Magician(1, "Бернар", 30, for1mage);
        Magician mage2 = new Magician(3, "Даниэль", 25, for2mage);

        Monster monster1 = new Monster(2, "Алонсо", 30, new Random().nextInt(10)+1);
        Monster monster2 = new Monster(4, "Карлос", 25, new Random().nextInt(10)+1);

        Character[] battlers = {mage1, mage2, monster1, monster2};
        */

        /* 3 СЦЕНА */
        Magician mage1 = new Magician(1, "Бернар", 30, for4mage);
        Monster monster1 = new Monster(2, "Алонсо", 30, new Random().nextInt(10)+1);

        Character[] battlers = {mage1, monster1};


        Scene game = new Scene(battlers);
        game.moving();
    }
}
