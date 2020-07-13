package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.character.Character;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Scene {
    public final int MIN_SCENE_SIZE = 2;
    public final int MAX_SCENE_SIZE = 20;

    private final int size;

    private final Map<Integer, Character> characters = new HashMap<>();
    private final List<Character> deadCharacters = new ArrayList<>();

    public Scene(int size) {
        if (size > MAX_SCENE_SIZE || size < MIN_SCENE_SIZE) {
            throw new IllegalArgumentException("Размер сцены должен быть не меньше " + MIN_SCENE_SIZE + " и не больше " + MAX_SCENE_SIZE);
        }
        this.size = size;
    }

    public void appendCharacterToRandomPosition(Character character)
    {
        if (characters.containsValue(character)) {
            throw new IllegalArgumentException("Персонаж уже на сцене: " + character);
        }

        boolean successfulAppend = false;
        for (int i = 0 ; i < MAX_SCENE_SIZE ; i++) {
            int potentialPosition = ThreadLocalRandom.current().nextInt(0, this.size - 1);
            if (!characters.containsKey(potentialPosition)) {
                characters.put (potentialPosition, character);
                successfulAppend = true;
                break;
            }
        }

        if (!successfulAppend) {
            for (int i = 0 ; i < MAX_SCENE_SIZE ; i++) {
                if (!characters.containsKey(i)) {
                    characters.put (i, character);
                    successfulAppend = true;
                    break;
                }
            }
        }

        if (!successfulAppend) {
            throw new RuntimeException("Не удалось найти свободную позицию на сцене для " + character);
        }
    }

    public Map<Integer, Character> getOpponentsFor(Character character) {
        return characters
                .entrySet()
                .stream()
                .filter((Map.Entry<Integer, Character> v) -> !v.getValue().isDead())
                .filter((Map.Entry<Integer, Character> item) -> !item.getValue().equals(character))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void run()
    {
        System.out.println("Начинается великая битва!");

        if (characters.isEmpty()) {
            System.out.println("Но похоже на нее ни кто не пришел");
            return;
        }

        System.out.printf("На поле боя столкнутся %s бойцов:\n\n", characters.size());

        int step = 0;
        while (getAliveCharacters().size() > 1) {
            step++;
            System.out.println("Шаг: " + step);
            for (Character character: getShuffledCharacters()) {
                if (!hasAnyOpponents()) {
                    break;
                }

                character.action(getOpponentsFor(character));

                checkBodies();
            }

            System.out.println();
        }

        showWinner();
    }

    private void showWinner() {
        List<Character> alive = getAliveCharacters();

        if (alive.size() != 0) {
            throw new RuntimeException("Что-то пошло не так");
        }

        Character winner = alive.get(0);

        System.out.println("На поле боя остался только " + winner.getName());
    }

    private List<Character> getAliveCharacters() {
        return characters
                .values()
                .stream()
                .filter(character -> !character.isDead())
                .collect(Collectors.toList());
    }

    private void checkBodies() {
        for (Map.Entry<Integer, Character> entry : characters.entrySet()) {
            Character character = entry.getValue();

            if (character.isDead() && !deadCharacters.contains(character)) {
                deadCharacters.add(character);
                System.out.println(character + " погибает");
            }
        }
    }

    private List<Character> getShuffledCharacters() {
        return characters
                .entrySet()
                .stream()
                .filter((Map.Entry<Integer, Character> v) -> !v.getValue().isDead())
                .sorted((Map.Entry<Integer, Character> a, Map.Entry<Integer, Character> b) -> ThreadLocalRandom.current().nextInt(-1, 1))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    private boolean hasAnyOpponents() {
        return characters
                .entrySet()
                .stream()
                .filter((Map.Entry<Integer, Character> v) -> !v.getValue().isDead())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .size() > 1;
    }
}
