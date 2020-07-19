package Game;

public class Game {
    public static final int NUMBER_POSITIONS = 10;
    public static final int LIMIT_NUMBER_STEPS_GAME = 1000;

    public static void main(String[] args) {
        Person[] p;
        Scene sceneMain = new Scene(null, NUMBER_POSITIONS);
        int counterActive = sceneMain.counterActivePersons();
        if(counterActive<2){
            System.out.println("Недостаточно персонажей. Запустите игру ещё раз!!!");
            return;
        }
        boolean maskScene[] = new boolean [NUMBER_POSITIONS];
        sceneMain.setMascScene(maskScene);
        int actionGameNumber = sceneMain.startNumber(maskScene);
        System.out.println("На сцене играют "+counterActive+" персонажей.");
        System.out.println("Начинает игру персонаж "+sceneMain.person[actionGameNumber].namePerson
                + " на позиции "+actionGameNumber+".");
        System.out.println("Персонажи расположились на сцене следующим образом:");
        sceneMain.scenePrint();
        System.out.println("\nИгра началась!\n");
        int stepCounter = 0;
        while ( counterActive > 1 & stepCounter<LIMIT_NUMBER_STEPS_GAME ) {
            int z =rnd(0,2);
            sceneMain.person[actionGameNumber].spell.cast(z);
            sceneMain.stepGame(actionGameNumber, maskScene, z, sceneMain.person[actionGameNumber].spell.power[z]);
            actionGameNumber = sceneMain.nextActionNumber(actionGameNumber, maskScene);
            counterActive = sceneMain.counterActivePersons();
            stepCounter++;
        }
        sceneMain.sceneFinishPrint(stepCounter);
    }


    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }



}
