package Game;

public class Game {
    public static final int NUMBER_POSITIONS = 10;
    public static final int LIMIT_NUMBER_STEPS_GAME = 100;
    int[] initPosition;
    int[] step;
    int startRandom;

    public Game(int[] initPosition, int[] step, int startRandom) {
        this.initPosition = initPosition;
        this.step = step;
        this.startRandom = startRandom;

        Scene sceneMain = new Scene(NUMBER_POSITIONS,initPosition);
        int counterActive = sceneMain.counterActivePersons();
        if(counterActive<2){
            System.out.println("Недостаточно персонажей. Запустите игру ещё раз!!!");
            return;
        }
        boolean[] maskScene = new boolean [NUMBER_POSITIONS];
        sceneMain.setMascScene(maskScene);
        int actionGameNumber = sceneMain.startNumber(maskScene,startRandom);
        System.out.println("На сцене играют "+counterActive+" персонажей.");
        System.out.println("Начинает игру персонаж "+sceneMain.person[actionGameNumber].namePerson
                + " на позиции "+actionGameNumber+".");
        sceneMain.scenePrint();
        System.out.println("\nИгра началась!\n");
        int stepCounter = 0;
        while ( counterActive > 1 & stepCounter<LIMIT_NUMBER_STEPS_GAME ) {
            sceneMain.person[actionGameNumber].spell.sayCast(step[stepCounter]);
            sceneMain.stepGame(actionGameNumber, maskScene, step[stepCounter], sceneMain.person[actionGameNumber].spell.power[step[stepCounter]]);
            actionGameNumber = sceneMain.nextActionNumber(actionGameNumber, maskScene);
            counterActive = sceneMain.counterActivePersons();
            stepCounter++;
        }
        sceneMain.sceneFinishPrint(stepCounter);
    }


}
