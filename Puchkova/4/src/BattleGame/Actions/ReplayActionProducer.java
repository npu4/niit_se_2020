package BattleGame.Actions;

import BattleGame.Character;
import BattleGame.Scene;

import java.util.Collection;

public class ReplayActionProducer implements ActionProducer {
    public static void replay(Character[] battlers, Collection<? super Action> actions) {
        Scene scene = new Scene(battlers);
        scene.introduceBattlers();

        for (Object act : actions) {
            Action action = (Action) act;
            Character[] targets = action.replay();
            for (Character target : targets) {
                if (target != null && target.isDead()) {
                    System.out.println(target.getType() + " " + target.getName() + " убит.");
                    for (int i = 0; i < battlers.length; i++) {
                        if (battlers[i] != null && target.getType().equals(battlers[i].getType()) && target.getName().equals(battlers[i].getName())) {
                            battlers[i] = null;
                        }
                    }
                }
            }
        }
        finish(battlers);
    }

    public static void finish(Character[] battlers) {
        Character aliveBattler = battlers[0];
        int numOfAliveCharacters = 0;
        for (Character battler : battlers) {
            if (battler != null) {
                aliveBattler = battler;
                numOfAliveCharacters++;
            }
        }
        switch (numOfAliveCharacters) {
            case 0:
                System.out.println("Все персонажи на поле умерли");
            case 1:
                System.out.println(aliveBattler.getType() + " " + aliveBattler.getName() + " победил");
            default:
                System.out.println("--------Конец игры--------");
                break;
        }
    }
}

