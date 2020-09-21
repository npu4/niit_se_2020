package BattleGame;

import BattleGame.Exceptions.BattlersOutOfBounds;
import BattleGame.Exceptions.TwoCharactersOnOnePlace;
import BattleGame.Spells.*;

import java.util.Random;

import static BattleGame.Spells.Spell.numOfSpells;

public class Scene {
    private final int MAX_NUM_OF_BATTLERS = 10;
    private final Character[] battlers = new Character[MAX_NUM_OF_BATTLERS];

    Scene(Character[] realBattlers) {
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
            exception.getMessage();
        }
    }

    Scene() {
        randomFilling();
    }

    public Character[] getBattlers() {
        return battlers;
    }

    void introduceBattlers(){
        System.out.println("На сцене:");
        int position = 0;
        for (Character battler: battlers) {
            position++;
            if(battler == null){
                continue;
            }
            StringBuilder introduce = new StringBuilder();
            introduce.append("На позиции ").append(position).append(" ").append(battler.getType()).append(" ").append(battler.getName())
                    .append(" с количеством здоровья ").append(battler.getHealth());
            System.out.println(introduce);
        }
        System.out.println();
    }

    public void moving() {
        introduceBattlers();

        int i = 0;
        while (!isFinish()) {
            if (battlers[i] != null) {
                battlers[i].attack(battlers);
                for (int j = 0; j < battlers.length; j++) {
                    if (battlers[j] != null && battlers[j].isDead()) {
                        System.out.println(battlers[j].getType() + " " + battlers[j].getName() + " убит.");
                        battlers[j] = null;
                    }
                }
            }
            i = (i + 1) % 10;
        }
    }

    boolean isFinish() {
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
                System.out.println("Все персонажи на поле умерли. Конец игры.");
                return true;
            case 1:
                System.out.println(aliveBattler.getType() + " " + aliveBattler.getName() + " победил. Конец игры.");
                return true;
            default:
                return false;
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
        int damage = new Random().nextInt(5) + 20;
        return new Monster(position, name, health, damage);
    }
}
