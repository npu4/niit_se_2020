package org.serieznyi.FightOfWizards;

import java.util.Scanner;
import java.util.logging.Logger;

final public class SceneOptions {
    private static final Logger LOG = Logger.getLogger(SceneOptions.class.getName());

    public final static int DEFAULT_SCENE_SIZE = 2;

    public final static int DEFAULT_CHARACTER_COUNT = 2;

    private int sceneSize = DEFAULT_SCENE_SIZE;

    private int characterCount = DEFAULT_CHARACTER_COUNT;

    private SceneOptions() {}

    public int getSceneSize() {
        return sceneSize;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public static SceneOptions fromDefault() {
        return new SceneOptions();
    }

    public static SceneOptions fromDialog() {
        SceneOptions options = new SceneOptions();

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Укажите размер сцены (По умолчанию %s):", DEFAULT_SCENE_SIZE);
        String sceneSize = scanner.nextLine();
        if (sceneSize.equals("")) {
            options.sceneSize = DEFAULT_SCENE_SIZE;
        } else {
            options.sceneSize = Integer.parseInt(sceneSize);
        }

        System.out.printf("Укажите количество персонажей на сцене (По умолчанию %s):", DEFAULT_CHARACTER_COUNT);
        String characterCount = scanner.nextLine();
        if (sceneSize.equals("")) {
            options.characterCount = DEFAULT_CHARACTER_COUNT;
        } else {
            options.characterCount = Integer.parseInt(characterCount);
        }

        if (options.characterCount > options.sceneSize) {
            throw new RuntimeException("Количество свободных мест на сцене меньше количества персонажей");
        }

        return options;
    }

    private static void initOption(SceneOptions options, String optionName, String value) {
        switch (optionName) {
            case "sceneSize": {
                options.sceneSize = Integer.parseInt(value);
                break;
            }
            case "characterCount": {
                options.sceneSize = Integer.parseInt(value);
                break;
            }
            default: {
                LOG.warning("Неизвестная опция: " + optionName);
            }
        }
    }
}
