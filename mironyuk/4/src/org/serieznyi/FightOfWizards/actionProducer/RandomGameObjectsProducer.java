package org.serieznyi.FightOfWizards.actionProducer;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.action.Action;
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

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

final public class RandomGameObjectsProducer implements ObjectsProducer {
    static final Logger LOGGER = Logger.create();

    private Set<Character> characters;

    private Iterator<Character> characterIterator;

    private boolean initialized = false;

    final private int characterCount;

    private Character nextCharacter;

    public RandomGameObjectsProducer(int characterCount)
    {
        this.characterCount = characterCount;
    }

    @Override
    public Set<Character> getCharacters(Scene scene, int count) {
        initialize();

        return characters;
    }

    @Override
    public Action nextAction(Scene scene) {
        initialize();

        if (getAliveCharactersCount(scene) <= 1) {
            return null;
        }

        if (characterIterator == null || !characterIterator.hasNext()) {
            initCharacterIterator();

            nextCharacter = characterIterator.next();

            scene.printStepInfo();
        } else {
            nextCharacter = characterIterator.next();
        }

        if (nextCharacter.isDead()) {
            return nextAction(scene);
        }

        return internalNextAction(scene);
    }

    private Action internalNextAction(Scene scene) {
        scene.printCharacterStepInfo(nextCharacter);

        return nextCharacter.produceAction(scene);
    }

    private int getAliveCharactersCount(Scene scene) {
        return scene.getAliveCharacters().size();
    }

    private void initialize() {
        if (initialized) {
            return;
        }

        CharacterFactory characterFactory = getCharacterFactory();

        characters = new HashSet<>();
        for (int i = 0; i < characterCount; i++) {
            characters.add(characterFactory.create());
        }

        initialized = true;
    }

    private void initCharacterIterator() {
        List<Character> shuffledCharacters = new ArrayList<>(characters);

        Collections.shuffle(shuffledCharacters);

        characterIterator = shuffledCharacters.iterator();
    }

    private NameFactory getNamesFactory() {

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

    private CharacterFactory getCharacterFactory() {
        NameFactory nameFactory = getNamesFactory();

        return new RandomCharacterFactory(
                new CharacterFactory[] {
                        new MonsterFactory(nameFactory), new WizardFactory(nameFactory, getSpellBagFactory())
                });
    }

    private SpellBagFactory getSpellBagFactory() {
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
