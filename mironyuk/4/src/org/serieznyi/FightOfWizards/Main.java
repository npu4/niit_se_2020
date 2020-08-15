package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.actionProducer.ObjectsProducer;
import org.serieznyi.FightOfWizards.actionProducer.RandomGameObjectsProducer;
import org.serieznyi.FightOfWizards.logging.Logger;
import org.serieznyi.FightOfWizards.logging.handler.OutputHandler;

public class Main {
  static final Logger LOGGER = Logger.create();

  public static void main(String[] args) {
    SceneOptions sceneOptions = getSceneOptions();

    Scene scene = new Scene(sceneOptions.getSceneSize(), getObjectProducer());

    LOGGER.setHandler(new OutputHandler());

    scene.run();
  }

  private static SceneOptions getSceneOptions() {
    return SceneOptions.fromDefault();
  }

  private static ObjectsProducer getObjectProducer() {
    SceneOptions sceneOptions = getSceneOptions();

    return new RandomGameObjectsProducer(sceneOptions.getCharacterCount());
  }
}
