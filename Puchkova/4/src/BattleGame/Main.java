package BattleGame;

import BattleGame.Actions.Action;
import BattleGame.Actions.RandomGameActionProducer;
import BattleGame.Actions.ReplayActionProducer;
import BattleGame.Exceptions.UnknownCommand;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Scanner;

import static BattleGame.Serializer.Serializer.*;
import static BattleGame.Serializer.Deserializer.*;

public class Main {
    final static String FILE_CHARACTERS = "C:/Users/natpuchk/IdeaProjects/niit_se/niit_se_2020/Puchkova/4/resourses/characters.xml";
    final static String FILE_ACTIONS = "C:/Users/natpuchk/IdeaProjects/niit_se/niit_se_2020/Puchkova/4/resourses/actions.xml";

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
                        try (FileWriter file = new FileWriter(FILE_CHARACTERS, false)) {
                            String serializeCharacters = serializeCharactersArray(characters);
                            file.write(serializeCharacters);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try (FileWriter file = new FileWriter(FILE_ACTIONS, false)) {
                            String serializeActions = serializeActions(randomGameActionProducer.getActions());
                            file.write(serializeActions);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("-----Реплей сохранен-----");
                    } else {
                        System.out.println("----Реплей не сохранен----");
                    }
                }
                case "2" -> {
                    System.out.println("--- Воспроизведение сохраненной игры ---");
                    Character[] characters = null;
                    Collection<? super Action> actions = null;
                    try (FileReader fileReader = new FileReader(FILE_CHARACTERS)) {
                        int c;
                        StringBuilder charactersString = new StringBuilder();
                        while ((c = fileReader.read()) != -1) {
                            charactersString.append((char) c);
                        }
                        characters = deserializeCharacterArray(charactersString.toString());
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    } catch (IOException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    try (FileReader fileReader = new FileReader(FILE_ACTIONS)) {
                        int c;
                        StringBuilder actionsString = new StringBuilder();
                        while ((c = fileReader.read()) != -1) {
                            actionsString.append((char) c);
                        }
                        actions = deserializeActionCollection(actionsString.toString());
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    } catch (IOException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    ReplayActionProducer replayActionProducer = new ReplayActionProducer (characters, actions);
                    replayActionProducer.action();
                }
                default -> throw new UnknownCommand();
            }
        } catch (UnknownCommand exception) {
            System.out.println(exception.getMessage());
        }
    }
}
