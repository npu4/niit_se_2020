package BattleGame;

public class Scene {
    private final int MAX_NUM_OF_BATTLERS = 10;
    private final Character[] battlers = new Character[MAX_NUM_OF_BATTLERS];

    Scene(Character[] realBattlers){
        if (realBattlers.length > MAX_NUM_OF_BATTLERS){
            System.out.println("Некорректное количество персонажей. В состязании участвуют первые 10.");
        }
        for (Character realBattler : realBattlers) {
            if (realBattler != null) {
                if (battlers[realBattler.getPosition()] == null) {
                    battlers[realBattler.getPosition()] = realBattler;
                } else {
                    System.out.println("Два персонажа претендовали на одно место. На сцене стоит первый претендующий.");
                }
            }
        }
    }

    public Character[] getBattlers() {
        return battlers;
    }

    public void moving(){
        int i = 0;
        while(! isFinish()){
            if (battlers[i] != null){
                battlers[i].attack(battlers);
                for (int j = 0; j < battlers.length; j++){
                    if(battlers[j] != null && battlers[j].isDead()){
                        System.out.println(battlers[j].getType() + " " + battlers[j].getName() + " убит.");
                        battlers[j] = null;
                    }
                }
            }
            i = (i + 1) % 10;
        }
    }

    boolean isFinish(){
        int i = 0;
        while(i < battlers.length && battlers[i] == null) {
            i++;
        }
        if (i >= battlers.length){
            System.out.println("Все персонажи на поле умерли. Конец игры.");
            return true;
        }
        else{
            int j = i+1;
            while(j < battlers.length && battlers[j] == null) {
                j++;
            }
            if (j >= battlers.length){
                System.out.println(battlers[i].getType() + " " + battlers[i].getName() + " победил. Конец игры.");
                return true;
            }
            else{
                return false;
            }

        }
    }
}
