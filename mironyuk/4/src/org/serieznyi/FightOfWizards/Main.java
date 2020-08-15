package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.action.CausingDamageAction;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.character.wizard.spell.FireTouchSpell;
import org.serieznyi.FightOfWizards.character.wizard.spell.HealingSpell;
import org.serieznyi.FightOfWizards.character.wizard.spell.LightningSpell;
import org.serieznyi.FightOfWizards.character.wizard.spell.UniversalSpell;
import org.serieznyi.FightOfWizards.factory.NameFactory;
import org.serieznyi.FightOfWizards.factory.SpellBagFactory;
import org.serieznyi.FightOfWizards.factory.character.CharacterFactory;
import org.serieznyi.FightOfWizards.factory.character.MonsterFactory;
import org.serieznyi.FightOfWizards.factory.character.RandomCharacterFactory;
import org.serieznyi.FightOfWizards.factory.character.WizardFactory;
import org.serieznyi.FightOfWizards.factory.name.NameRule;
import org.serieznyi.FightOfWizards.logging.Logger;
import org.serieznyi.FightOfWizards.logging.handler.OutputHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class Main {
  static final Logger LOGGER = Logger.create();

  public static void main(String[] args) {
    SceneOptions sceneOptions = SceneOptions.fromDefault();

    Scene scene = buildScene(sceneOptions);

    LOGGER.setHandler(new OutputHandler());

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

  private static class Dependencies {
    public static NameFactory getNamesFactory() {

      List<NameRule> nameRules = new ArrayList<>();

      nameRules.add(
          new NameRule(
              Character.Type.MONSTER,
              new String[] {"Сатана", "Кракен", "Голод", "Голум", "Харрун", "Ворон", "Зомби"},
              new String[] {
                "Мерзкий",
                "Коварный",
                "Подлый",
                "Злобный",
                "Отвратительный",
                "Раздирающий",
                "Кровавый"
              }));

      nameRules.add(
          new NameRule(
              Character.Type.MONSTER,
              new String[] {"Смерть", "Чума", "Крыса"},
              new String[] {
                "Мерзкая",
                "Коварная",
                "Подлая",
                "Злобная",
                "Отвратительная",
                "Раздирающая",
                "Кровавая"
              }));

      nameRules.add(
          new NameRule(
              Character.Type.WIZARD,
              new String[] {
                "Арарат", "Байтум", "Гендальф", "Гигабайтум", "Килабайтум", "Косинусин",
                "Мегабайтум", "Мерлин", "Синусин", "Тангенсин", "Терабайтум", "Тирисиум"
              },
              new String[] {
                "Светлый", "Темный", "Одинокий", "Лесной", "Синий", "Дряхлый", "Свирепый"
              }));

      return new NameFactory(nameRules);
    }

    public static CharacterFactory getCharacterFactory() {
      NameFactory nameFactory = getNamesFactory();

      return new RandomCharacterFactory(
          new CharacterFactory[] {
            new MonsterFactory(nameFactory), new WizardFactory(nameFactory, getSpellBagFactory())
          });
    }

    public static SpellBagFactory getSpellBagFactory() {
      ThreadLocalRandom random = ThreadLocalRandom.current();

      final int MIN_HEALING = 25;
      final int MAX_HEALING = 50;
      final int MIN_SPELL_DAMAGE = 50;
      final int MAX_SPELL_DAMAGE = 75;

      Supplier<Integer> damageGenerator =
          () -> random.nextInt(MIN_SPELL_DAMAGE, MAX_SPELL_DAMAGE + 1);

      Set<Spell> spells = new HashSet<>();

      spells.add(new HealingSpell(random.nextInt(MIN_HEALING, MAX_HEALING + 1)));

      spells.add(new LightningSpell(damageGenerator.get()));

      spells.add(new FireTouchSpell(damageGenerator.get()));

      Spell chainLightingSpell =
          UniversalSpell.builder()
              .withName("Цепная молния")
              .withDescription("Наносит урон, всем персонажам на сцене, кроме мага, который произносит заклинание.")
              .withTargetsFinder((c, s) -> s.getOpponentsFor(c))
              .withValue(damageGenerator.get())
              .withActionCreator(a -> o -> v -> CausingDamageAction
                      .builder()
                      .withInitiator(a)
                      .addTargets(o)
                      .causeLightingDamage(v.intValue())
                      .build())
              .withSuccessfulCallback(
                  w -> s -> c -> v -> LOGGER.takenDamage(w, s, c, v.intValue()))
              .build();

      spells.add(chainLightingSpell);

      Spell banishingMonstersSpell =
          UniversalSpell.builder()
              .withName("Изгнание монстров")
              .withDescription("Наносит урон всем монстрам")
              .withTargetsFinder((c, s) -> s.getOpponentsFor(c, Character.Type.MONSTER))
              .withValue(damageGenerator.get())
              .withActionCreator(a -> o -> v -> CausingDamageAction
                      .builder()
                      .withInitiator(a)
                      .addTargets(o)
                      .causeMagicalDamage(v.intValue())
                      .build())
              .withSuccessfulCallback(w -> s -> c -> v -> LOGGER.takenDamage(w, s, c, v.intValue()))
              .build();

      spells.add(banishingMonstersSpell);

      Spell migraineSpell =
          UniversalSpell.builder()
              .withName("Мигрень")
              .withDescription("Наносит урон всем магам")
              .withTargetsFinder((c, s) -> s.getOpponentsFor(c, Character.Type.WIZARD))
              .withValue(damageGenerator.get())
              .withActionCreator(a -> o -> v -> CausingDamageAction
                      .builder()
                      .withInitiator(a)
                      .addTargets(o)
                      .causeMagicalDamage(v.intValue())
                      .build())
              .withSuccessfulCallback(w -> s -> c -> v -> LOGGER.takenDamage(w, s, c, v.intValue()))
              .build();

      spells.add(migraineSpell);

      Spell wallOfFireSpell =
          UniversalSpell.builder()
              .withName("Стена огня")
              .withDescription("Наносит урон всем персонажам на четных позициях")
              .withTargetsFinder((c, s) -> s.getOpponentsFor(c, Character.Type.MONSTER))
              .withValue(damageGenerator.get())
              .withActionCreator(a -> o -> v -> CausingDamageAction
                      .builder()
                      .withInitiator(a)
                      .addTargets(o)
                      .causeFireDamage(v.intValue())
                      .build())
              .withSuccessfulCallback(w -> s -> c -> v -> LOGGER.takenDamage(w, s, c, v.intValue()))
              .build();

      spells.add(wallOfFireSpell);

      return new SpellBagFactory(spells);
    }
  }
}
