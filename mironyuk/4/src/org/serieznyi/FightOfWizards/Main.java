package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.actionProducer.ObjectsProducer;
import org.serieznyi.FightOfWizards.actionProducer.RandomGameObjectsProducer;
import org.serieznyi.FightOfWizards.logging.Logger;
import org.serieznyi.FightOfWizards.logging.handler.OutputHandler;
import org.serieznyi.serialization.XmlPrettyFormatter;
import org.serieznyi.serialization.serializer.Serializer;
import org.serieznyi.serialization.serializer.exception.FormatNotSupportedException;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final Serializer serializer = new Serializer();
  static final Logger LOGGER = Logger.create();

  public static void main(String[] args) {
    SceneOptions sceneOptions = getSceneOptions();

    Scene scene = new Scene(sceneOptions.getSceneSize(), getObjectProducer());

    LOGGER.setHandler(new OutputHandler());

    scene.run();

    if (isSaveReplay()) {
      Path replayPath = getReplayPath("Укажите полный путь к файлу в который будет сохранен replay. Имя файла должно заканчиваться на .xml");

      saveReplay(replayPath, scene.getHistory());
    }
  }

  private static boolean isSaveReplay() {
    Scanner scanner = new Scanner(System.in);

    String answer;

    while (true) {
      System.out.println("\nХотите сохранить реплей? да\\нет\n");

      answer = scanner.next();

      if (!answer.equalsIgnoreCase("Да") && !answer.equalsIgnoreCase("Нет")) {
        System.out.println("Неверный формат ответа. Попробуй-те еще раз");
        continue;
      }

      break;
    }

    return answer.equalsIgnoreCase("Да");
  }

  private static Path getReplayPath(String message) {
    Scanner scanner = new Scanner(System.in);

    Path path;

    while (true) {
      System.out.println("\n" + message + "\n");

      path = Paths.get(scanner.next()).toAbsolutePath();

      if (!path.toString().endsWith(".xml")) {
        System.out.println("Неверное расширение файла. Попробуй-те еще раз");
        continue;
      }

      path.getParent().toFile().mkdirs();

      break;
    }

    return path;
  }

  private static void createDirIfNotExists(File dir) {
  }

  private static void saveReplay(Path replayPath, List<Action> history) {
    try {
      System.out.println("Пытаюсь сохранить snapshot в " + replayPath);

      String xml = serializer.serialize(new Snapshot(history), Serializer.Format.XML);
      XmlPrettyFormatter formatter = new XmlPrettyFormatter();

      try (Writer writer = new FileWriter(replayPath.toFile())) {
        writer.write(formatter.toPrettyView(xml));
      }

      System.out.println("Snapshot сохранен: " + replayPath);
    } catch (FormatNotSupportedException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static SceneOptions getSceneOptions() {
    return SceneOptions.fromDefault();
  }

  private static ObjectsProducer getObjectProducer() {
    SceneOptions sceneOptions = getSceneOptions();

    return new RandomGameObjectsProducer(sceneOptions.getCharacterCount());
  }
}
