package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Monster;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
  private static final int SCENE_SIZE = 2;
  private static final int COUNT_CHARACTER = 2;
  private static final NamesPool namesPool = new NamesPool();

  public static void main(String[] args) {
    Scene scene = buildScene();

    scene.run();
  }

  private static Scene buildScene() {
    if (SCENE_SIZE < COUNT_CHARACTER) {
      throw new RuntimeException("Количество свободных мест на сцене меньше количества персонажей");
    }

    Scene scene = new Scene(SCENE_SIZE);

    for (int i = 0; i < COUNT_CHARACTER; i++) {
      scene.appendCharacterToRandomPosition(createMonster());
    }

    return scene;
  }

  private static Character createMonster() {
    return new Monster(
            namesPool.extractMonsterName(),
            ThreadLocalRandom.current().nextInt(50, 100),
            ThreadLocalRandom.current().nextInt(10, 20)
    );
  }
}
