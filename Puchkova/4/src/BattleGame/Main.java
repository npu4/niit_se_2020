package BattleGame;

import BattleGame.Actions.RandomGameActionProducer;
import BattleGame.Actions.ReplayActionProducer;
import BattleGame.Exceptions.UnknownCommand;

import java.io.*;
import java.util.Scanner;

import static BattleGame.Serializer.serializeCharacters;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Начать новую игру или воспроизвести сохраненную? 1\\2");
        String answer1;
        Scanner scanner1 = new Scanner(System.in);
        answer1 = scanner1.nextLine();
        try {
            switch (answer1) {
                case "1" -> {
                    RandomGameActionProducer randomGameActionProducer = new RandomGameActionProducer();
                    Character[] characters = randomGameActionProducer.getBattlers();
                    randomGameActionProducer.action();
                    System.out.println("\nХотите сохранить реплей? Да\\Нет");
                    String answer2;
                    Scanner scanner2 = new Scanner(System.in);
                    answer2 = scanner2.nextLine();
                    if (answer2.equals("Да")) {
                        try (FileWriter file = new FileWriter("C:/Users/natpuchk/IdeaProjects/niit_se/niit_se_2020/Puchkova/4/resourses/characters.xml", false)) {
                            String s = serializeCharacters(characters);
                            file.write(s);
                            System.out.println("--- Воспроизведение сохраненной игры ---");
                            ReplayActionProducer.replay(characters, randomGameActionProducer.getActions());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                case "2" -> System.out.println("--- Воспроизведение сохраненной игры ---");
                default -> throw new UnknownCommand();
            }
        } catch (UnknownCommand exception) {
            System.out.println(exception.getMessage());
        }
    }
}
