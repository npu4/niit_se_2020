package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.character.wizard.spell.*;
import org.serieznyi.FightOfWizards.factory.NameFactory;
import org.serieznyi.FightOfWizards.factory.SpellBagFactory;
import org.serieznyi.FightOfWizards.factory.character.CharacterFactory;
import org.serieznyi.FightOfWizards.factory.character.MonsterFactory;
import org.serieznyi.FightOfWizards.factory.character.RandomCharacterFactory;
import org.serieznyi.FightOfWizards.factory.character.WizardFactory;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
  public static void main(String[] args) {
    SceneOptions sceneOptions = SceneOptions.fromDefault();

    Scene scene = buildScene(sceneOptions);

    scene.run();
  }

  private static Scene buildScene(SceneOptions sceneOptions) {
    CharacterFactory characterFactory = Dependencies.getCharacterFactory();

    Scene scene = new Scene(sceneOptions.getSceneSize());

    for (int i = 0; i < sceneOptions.getCharacterCount(); i++) {
      scene.appendCharacterToRandomPosition(characterFactory.create());
    }

    return scene;
  }

  private static class Dependencies
  {
    public static CharacterFactory getCharacterFactory()
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
              new WizardFactory(nameFactory, getSpellBagFactory())
      });
    }

    public static SpellBagFactory getSpellBagFactory()
    {
      ThreadLocalRandom random = ThreadLocalRandom.current();

      final int MIN_HEALING = 25;
      final int MAX_HEALING = 50;
      final int MIN_SPELL_DAMAGE = 50;
      final int MAX_SPELL_DAMAGE = 75;

      return new SpellBagFactory(new Spell[]{
              new Healing(random.nextInt(MIN_HEALING, MAX_HEALING + 1)),
              new Lightning(random.nextInt(MIN_SPELL_DAMAGE, MAX_SPELL_DAMAGE + 1)),
              new BanishingMonsters(random.nextInt(MIN_SPELL_DAMAGE, MAX_SPELL_DAMAGE + 1)),
              new ChainLighting(random.nextInt(MIN_SPELL_DAMAGE, MAX_SPELL_DAMAGE + 1))
      });
    }
  }
}
