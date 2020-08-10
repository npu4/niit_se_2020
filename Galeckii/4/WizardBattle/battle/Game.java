package battle;

import battle.characters.Character;

import java.io.*;

public class Game {

    public static void main(String[] args) throws IOException {

        System.out.println("Воспроизвести сохраненную игру? да/нет");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        if (answer.equalsIgnoreCase("да")) {
            System.out.println("Введите путь к реплею");
            answer = reader.readLine();
            printSavedGame(answer);
        } else {
            startNewGame();
        }

        reader.close();
    }

    public static void printSavedGame(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startNewGame() throws IOException {
        Scene scene = new Scene();
        scene.createScene();
        GameLog gameLog = new GameLog();

        while (true) {
            for (Character ch : scene.getPositions()) {
                if (ch != null) {
                    ch.attack(scene.getPositions(), gameLog);
                }
            }
            if (scene.isGameFinished()) {
                scene.printWinner(gameLog);
                System.out.println(gameLog.getLog());
                break;
            }
        }

        System.out.println("Сохранить игру?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();

        if (answer.equalsIgnoreCase("да")) {
            System.out.println("Укажите путь к файлу");
            answer = reader.readLine();
            gameLog.saveGame(answer);
        }

        reader.close();
    }
}
