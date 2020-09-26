package BattleGame.Actions;

import BattleGame.Character;
import BattleGame.Magician;
import BattleGame.Monster;
import BattleGame.Scene;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static BattleGame.Scene.MAX_NUM_OF_BATTLERS;

public class RandomGameActionProducer implements ActionProducer {
    Collection<? super Action> actions;
    Scene scene;
    Character[] battlers;

    public RandomGameActionProducer(){
        scene = new Scene();
        scene.introduceBattlers();
        battlers = scene.getBattlers();
    }

    public Collection<? super Action> getActions() {
        return actions;
    }

    public Scene getScene() {
        return scene;
    }

    public Character[] getBattlers() {
        Character[] characters = new Character[MAX_NUM_OF_BATTLERS];
        for (int i = 0; i < MAX_NUM_OF_BATTLERS; i++) {
            if(battlers[i] != null){
                characters[i] = battlers[i].clone();
            }
        }
        return characters;
    }

    public void action(){
        actions = new ArrayList<>();

        int i = 0;
        while (scene.notFinish()) {
            if (battlers[i] != null) {
                if (battlers[i] instanceof Magician) {
                    MagicianAction magicianAction = new MagicianAction(((Magician) battlers[i]).clone(),
                            ((Magician) battlers[i]).getSpellUsed(),
                            new Random().nextInt(10) + 1);
                    magicianAction.action(battlers);
                    actions.add(magicianAction);
                }
                if (battlers[i] instanceof Monster) {
                    MonsterAction monsterAction = new MonsterAction(((Monster) battlers[i]).clone(),
                            ((Monster) battlers[i]).getDamage());
                    monsterAction.action(battlers);
                    actions.add(monsterAction);
                }
                for (int j = 0; j < battlers.length; j++) {
                    if (battlers[j] != null && battlers[j].isDead()) {
                        System.out.println(battlers[j].getType() + " " + battlers[j].getName() + " убит");
                        battlers[j] = null;
                    }
                }
            }
            i = (i + 1) % 10;
        }
    }
}
