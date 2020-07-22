package org.serieznyi.FightOfWizards;

import java.util.Scanner;

public final class SceneOptions {
  public static final int DEFAULT_SCENE_SIZE = 10;
  public static final int DEFAULT_CHARACTER_COUNT = 10; // TODO использовать
  private int sceneSize = DEFAULT_SCENE_SIZE;
  private int characterCount = DEFAULT_CHARACTER_COUNT;

  private SceneOptions() {}

  public static SceneOptions fromDefault() {
    return new SceneOptions();
  }

  public static SceneOptions fromDialog() {
    SceneOptions options = new SceneOptions();

    while (true) {
      DialogOptions dialogOptions = new DialogOptions();

      options.sceneSize = dialogOptions.parseSceneSize();
      options.characterCount = dialogOptions.parseCharacterCount();

      if (options.characterCount > options.sceneSize) {
        System.out.println(
            "Количество свободных мест на сцене меньше количества персонажей. \nПопробуйте снова");
        continue;
      }

      break;
    }

    return options;
  }

  public int getSceneSize() {
    return sceneSize;
  }

  public int getCharacterCount() {
    return characterCount;
  }

  private static class DialogOptions {
    private final Scanner scanner;

    DialogOptions() {
      scanner = new Scanner(System.in);
    }

    private int parseSceneSize() {
      while (true) {
        System.out.printf("Укажите размер сцены (По умолчанию %s):", DEFAULT_SCENE_SIZE);

        try {
          String sceneSize = scanner.nextLine();

          return sceneSize.equals("") ? DEFAULT_SCENE_SIZE : Integer.parseInt(sceneSize);
        } catch (Throwable e) {
          System.out.println("Неверное значение. Попробуйте еще.");
        }
      }
    }

    private int parseCharacterCount() {
      while (true) {
        System.out.printf(
            "Укажите количество персонажей на сцене (По умолчанию %s): ", DEFAULT_CHARACTER_COUNT);

        try {
          String characterCount = scanner.nextLine();

          return characterCount.equals("") ? DEFAULT_SCENE_SIZE : Integer.parseInt(characterCount);
        } catch (Throwable e) {
          System.out.println("Неверное значение. Попробуйте еще.");
        }
      }
    }
  }
}
