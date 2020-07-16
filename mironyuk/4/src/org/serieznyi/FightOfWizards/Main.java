package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.factory.NameFactory;
import org.serieznyi.FightOfWizards.factory.character.CharacterFactory;
import org.serieznyi.FightOfWizards.factory.character.MonsterFactory;
import org.serieznyi.FightOfWizards.factory.character.RandomCharacterFactory;
import org.serieznyi.FightOfWizards.factory.character.WizardFactory;

import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    SceneOptions sceneOptions = SceneOptions.fromDefault();

    Scene scene = buildScene(sceneOptions);

    scene.run();
  }

  private static Scene buildScene(SceneOptions sceneOptions) {
    CharacterFactory characterFactory = getCharacterFactory();

    Scene scene = new Scene(sceneOptions.getSceneSize());

    for (int i = 0; i < sceneOptions.getCharacterCount(); i++) {
      scene.appendCharacterToRandomPosition(characterFactory.create());
    }

    return scene;
  }

  private static CharacterFactory getCharacterFactory()
  {
    NameFactory nameFactory = new NameFactory(new HashMap<Character.Type, String[]>() {{
      put(Character.Type.MONSTER, new String[]{
        "Сатана",
        "Кракен",
        "Голод",
        "Голум",
        "Харрун",
        "Смерть",
        "Чума",
        "Ворон",
        "Крыса",
        "Зомби",
      });
      put(Character.Type.WIZARD, new String[]{
        "Мерлин",
        "Арарат",
        "Синусин",
        "Косинусин",
        "Тангенсин",
        "Байтум",
        "Килабайтум",
        "Мегабайтум",
        "Гигабайтум",
        "Терабайтум",
        "Гендальф",
        "Тирисиум",
      });
    }});

    return new RandomCharacterFactory(new CharacterFactory[] {
            new MonsterFactory(nameFactory),
            new WizardFactory(nameFactory)
    });
  }
}
