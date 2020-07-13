package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Monster;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
  private static final NamesPool namesPool = new NamesPool();

  public static void main(String[] args) {
    SceneOptions sceneOptions = SceneOptions.fromDefault();

    Scene scene = buildScene(sceneOptions);

    scene.run();
  }

  private static Scene buildScene(SceneOptions sceneOptions) {
    Scene scene = new Scene(sceneOptions.getSceneSize());

    for (int i = 0; i < sceneOptions.getCharacterCount(); i++) {
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
