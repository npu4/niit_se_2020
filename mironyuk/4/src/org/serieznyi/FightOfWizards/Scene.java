package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.character.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Scene {
    public final int MAX_SCENE_SIZE = 100;

    private final int size;

    private final Map<Integer, Character> characters = new HashMap<>();

    public Scene(int size) {
        if (size > MAX_SCENE_SIZE) {
            throw new IllegalArgumentException("Максимальный размер сцены: " + MAX_SCENE_SIZE);
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
            int potentialPosition = ThreadLocalRandom.current().nextInt(0, this.size);

            if (!characters.containsKey(potentialPosition)) {
                characters.put (potentialPosition, character);
                successfulAppend = true;
                break;
            }
        }

        if (!successfulAppend) {
            throw new RuntimeException("Не удалось найти свободную позицию на сцене для " + character);
        }
    }

    public void run()
    {
        System.out.println("Начинается могучая битва");

        if (characters.isEmpty()) {
            System.out.println("Но кажется на нее ни кто не пришел");
            return;
        }

        for (Map.Entry<Integer, Character> character: characters.entrySet()) {
            System.out.println(character);
        }
    }
}
