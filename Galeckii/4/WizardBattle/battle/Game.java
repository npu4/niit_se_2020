package battle;

import battle.characters.Character;
import battle.characters.Monster;
import battle.characters.Wizard;

public class Game {
    static Scene scene = new Scene();

    static {
        scene.createScene();
    }

    public static void main(String[] args) {
        while (true) {
            for (Character ch : scene.getPositions()) {
                if (ch != null) {
                    ch.attack(scene.getPositions());
                }
            }
            if (isGameFinished()) {
                printWinner();
                break;
            }
        }
    }

    public static boolean isGameFinished() {
        int alivePlayers = 0;
        for (Character ch : scene.getPositions()) {
            if (ch != null)
                alivePlayers++;
        }
        return alivePlayers == 1;
    }

    public static void printWinner() {
        String winner = "";
        for (Character character : scene.getPositions()) {
            if (character != null) {
                winner = character.getName();
                break;
            }
        }
        System.out.println(winner + " победил!");
    }
}
