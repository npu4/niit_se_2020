package BattleGame;

import BattleGame.Exceptions.BattlersOutOfBounds;
import BattleGame.Exceptions.TwoCharactersOnOnePlace;
import BattleGame.Spells.*;

import java.util.Random;

import static BattleGame.Spells.Spell.numOfSpells;

public class Scene {
    public static final int MAX_NUM_OF_BATTLERS = 10;
    private final Character[] battlers = new Character[MAX_NUM_OF_BATTLERS];

    public Scene(Character[] realBattlers) {
        try {
            if (realBattlers.length > MAX_NUM_OF_BATTLERS) {
                throw new BattlersOutOfBounds();
            }
            for (Character realBattler : realBattlers) {
                if (realBattler != null) {
                    if (battlers[realBattler.getPosition()] == null) {
                        battlers[realBattler.getPosition()] = realBattler;
                    } else {
                        throw new TwoCharactersOnOnePlace();
                    }
                }
            }
        } catch (TwoCharactersOnOnePlace | BattlersOutOfBounds exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Scene() {
        randomFilling();
    }

    public Character[] getBattlers() {
        return battlers;
    }

    public void introduceBattlers(){
        System.out.println("На сцене:");
        int position = 0;
        for (Character battler: battlers) {
            position++;
            if(battler == null){
                continue;
            }
            String introduce = "На позиции " + position + " " + battler.getType() + " " + battler.getName() +
                    " с количеством здоровья " + battler.getHealth();
            System.out.println(introduce);
        }
        System.out.println();
    }

    public boolean notFinish() {
        Character aliveBattler = battlers[0];
        int numOfAliveCharacters = 0;
        for (Character battler : battlers) {
            if (battler != null) {
                aliveBattler = battler;
                numOfAliveCharacters++;
            }
        }
        switch (numOfAliveCharacters){
            case 0:
                System.out.println("Все персонажи на поле умерли");
                System.out.println("--------Конец игры--------");
                return false;
            case 1:
                System.out.println(aliveBattler.getType() + " " + aliveBattler.getName() + " победил");
                System.out.println("--------Конец игры--------");
                return false;
            default:
                return true;
        }
    }

    void randomFilling() {
        String[] names = {"Бернар", "Даниэль", "Фредерик", "Тьерри", "Алонсо", "Карлос", "Мануэль", "Диего", "Эмилиано", "Йонас"};
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int r = new Random().nextInt(5);
            switch (r) {
                case 0:
                    battlers[i] = randomMag(i, names[count++]);
                    break;
                case 1:
                    battlers[i] = randomMonster(i, names[count++]);
                    break;
                default:
                    break;
            }
        }
    }

    Magician randomMag(int position, String name) {
        int health = new Random().nextInt(10) + 20;
        Spell[] spells = new Spell[3];
        for (int i = 0; i < 3; i++) {
            int numSpell = new Random().nextInt(numOfSpells);
            switch (numSpell) {
                case 0 -> spells[i] = new ChainLighting();
                case 1 -> spells[i] = new ExpellingMonsters();
                case 2 -> spells[i] = new FieryTouch();
                case 3 -> spells[i] = new Healing();
                case 4 -> spells[i] = new Lightning();
                case 5 -> spells[i] = new Migraine();
                case 6 -> spells[i] = new WallOfFire();
            }
        }
        return new Magician(position, name, health, spells);
    }

    Monster randomMonster(int position, String name) {
        int health = new Random().nextInt(10) + 20;
        int damage = new Random().nextInt(10) + 1;
        return new Monster(position, name, health, damage);
    }
}
