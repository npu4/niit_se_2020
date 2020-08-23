package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.actionProducer.ObjectsProducer;
import org.serieznyi.FightOfWizards.actionProducer.RandomGameObjectsProducer;
import org.serieznyi.FightOfWizards.actionProducer.ReplayActionProducer;
import org.serieznyi.FightOfWizards.logging.Logger;
import org.serieznyi.FightOfWizards.logging.handler.OutputHandler;
import org.serieznyi.serialization.XmlPrettyFormatter;
import org.serieznyi.serialization.serializer.Serializer;
import org.serieznyi.serialization.serializer.exception.FormatNotSupportedException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  static final Serializer serializer = new Serializer();
  static final Logger LOGGER = Logger.create();
  static SceneOptions sceneOptions;

  public static void main(String[] args) throws IOException, FormatNotSupportedException, XmlPrettyFormatter.FormattingException {
    sceneOptions = getSceneOptions();

    GameMode gameMode = GameMode.REPLAY; // TODO
//    GameMode gameMode = chooseGameMode();

    if (gameMode == GameMode.EXIT) {
      System.exit(0);
    }

    Scene scene = new Scene(sceneOptions.getSceneSize(), getProducer(gameMode));

    LOGGER.setHandler(new OutputHandler());

    scene.run();

    if (isSaveReplay()) {
      Path replayPath = getReplayPathForSave();

      replayPath.getParent().toFile().mkdirs();

      saveReplay(replayPath, new Snapshot(scene.getHistory(), scene.getCharacters()));
    }
  }

  private static ObjectsProducer getProducer(GameMode gameMode) {
    if (GameMode.REPLAY == gameMode) {
      return makeReplayActionProducer();
    } else {
      return makeRandomGameObjectProducer();
    }
  }

  private static GameMode chooseGameMode() {
    Scanner scanner = new Scanner(System.in);

    String message = Arrays
            .stream(GameMode.values())
            .sorted(Comparator.reverseOrder())
            .map((m) -> " - " + m.toString() + "[" + m.ordinal() + "]")
            .reduce("", (a, b) -> b + "\n" + a);

    while (true) {
      System.out.println(message);

      try {
        String answer = scanner.next();

        int modeIndex = Integer.parseInt(answer);

        GameMode[] modes = GameMode.values();

        if (modeIndex <= modes.length) {
          return modes[modeIndex];
        }
      } catch (NumberFormatException ignored) {
        System.out.println("Неверный формат ответа или неверное значение. Попробуй-те еще раз");
      }
    }
  }

  private static ReplayActionProducer makeReplayActionProducer() {
    return new ReplayActionProducer(Paths.get("asd.xml")); // TODO
//    return new ReplayActionProducer(getReplayPathForRestore());
  }

  private static RandomGameObjectsProducer makeRandomGameObjectProducer() {
    return new RandomGameObjectsProducer(sceneOptions.getCharacterCount());
  }

  private static boolean isSaveReplay() {
    Scanner scanner = new Scanner(System.in);

    String answer;

    while (true) {
      System.out.println("\nХотите сохранить реплей? да(1)\\нет(2)\n");

      answer = scanner.next().toLowerCase();

      if (!Arrays.asList("да", "нет", "1", "2").contains(answer.toLowerCase())) {
        System.out.println("Неверный формат ответа. Попробуй-те еще раз");
        continue;
      }

      break;
    }

    return answer.equals("да") || answer.equals("1");
  }

  private static Path getReplayPathForSave() {
    Scanner scanner = new Scanner(System.in);

    Path path;

    while (true) {
      System.out.println(
              "\nУкажите путь к файлу в который будет сохранен replay. Имя файла должно заканчиваться на .xml\n"
      );

      path = Paths.get(scanner.next()).toAbsolutePath();

      if (!path.toString().endsWith(".xml")) {
        System.out.println("Неверное расширение файла. Попробуй-те еще раз");
        continue;
      }

      break;
    }

    return path;
  }

  private static Path getReplayPathForRestore() {
    Scanner scanner = new Scanner(System.in);

    Path path;

    while (true) {
      System.out.println(
              "\nУкажите путь к XML файлу сохранения\n"
      );

      path = Paths.get(scanner.next()).toAbsolutePath();

      if (!path.toString().endsWith(".xml")) {
        System.out.println("Неверное расширение файла. Попробуй-те еще раз");
        continue;
      }

      if (!path.toFile().exists()) {
        System.out.println("Файл не существует. Попробуй-те еще раз");
        continue;
      }

      break;
    }

    return path;
  }

  private static void saveReplay(Path replayPath, Snapshot snapshot)
          throws FormatNotSupportedException, IOException, XmlPrettyFormatter.FormattingException {
    System.out.println("Пытаюсь сохранить snapshot в " + replayPath);

    String xml = serializer.serialize(snapshot, Serializer.Format.XML);

    XmlPrettyFormatter formatter = new XmlPrettyFormatter();

    try (Writer writer = new FileWriter(replayPath.toFile())) {
      writer.write(formatter.toPrettyView(xml));
    }

    System.out.println("Snapshot сохранен: " + replayPath);
  }

  private static SceneOptions getSceneOptions() {
    return SceneOptions.fromDefault();
  }

  enum GameMode {
    NEW,
    REPLAY,
    EXIT;

    @Override
    public String toString() {
      if (this == NEW) {
        return "Начать новую игру";
      } if (this == REPLAY) {
        return "Воспроизвести сохраненную игру";
      } else {
        return "Выход";
      }
    }
  }
}
