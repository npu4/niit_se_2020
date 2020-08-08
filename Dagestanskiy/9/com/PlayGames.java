import Game.Game;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static Game.Game.LIMIT_NUMBER_STEPS_GAME;
import static Game.Game.NUMBER_POSITIONS;

public class PlayGames {
    public static void main(String[] args) {

        int[] initPosition = new int[NUMBER_POSITIONS];
        int[] step = new int[LIMIT_NUMBER_STEPS_GAME];
        int start;
        Scanner scanner = new Scanner(System.in);

        if (HelpUtil.qwestionAnswer("Хотите проиграть реплей?", scanner)) {

            System.out.print("Введите путь\\имя файла  : ");
            String nameFile = scanner.nextLine();
            try (FileReader reader = new FileReader( nameFile)) {
                Scanner scan = new Scanner(reader);
                String resultRead = scan.nextLine();
                String[] substrResult = resultRead.split("<");
                String[] substrInitPosition = substrResult[1].split(",");
                String[] substrStep = substrResult[2].split(",");
                for (int i = 0; i < initPosition.length; i++) initPosition[i] = Integer.parseInt(substrInitPosition[i]);
                for (int i = 0; i < step.length; i++) step[i] = Integer.parseInt(substrStep[i]);
                start = Integer.parseInt(substrResult[0]);

                new Game(initPosition, step, start);

                scan.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            for (int i = 0; i < initPosition.length; i++) initPosition[i] = HelpUtil.rndInt(0, 2);
            for (int i = 0; i < step.length; i++) step[i] = HelpUtil.rndInt(0, 2);
            start = HelpUtil.rndInt(0, NUMBER_POSITIONS - 1);

            new Game(initPosition, step, start);

            String replay = start + "<" + HelpUtil.arrayIntToString(initPosition, ",") +
                    "<" + HelpUtil.arrayIntToString(step, ",");
            if (HelpUtil.qwestionAnswer("Хотите записать реплей?", scanner)) {
                HelpUtil.writeStringToFile(replay, scanner);
            } else System.out.println("Реплей не сохранен.");
        }

        scanner.close();
    }


}

