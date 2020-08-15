package org.serieznyi.FightOfWizards;

import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.logging.Logger;
import org.serieznyi.FightOfWizards.util.Functions;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Scene {
  static final Logger LOGGER = Logger.create();
  public final int MIN_SCENE_SIZE = 2;
  public final int MAX_SCENE_SIZE = 20;
  private final int size;
  private final Map<Integer, Character> characters = new HashMap<>();
  private final List<Character> deadCharacters = new ArrayList<>();
  private State state;
  final private ActionConsumer producer = new ActionConsumer();

  public Scene(int size) {
    if (size > MAX_SCENE_SIZE || size < MIN_SCENE_SIZE) {
      throw new IllegalArgumentException(
          "Размер сцены должен быть не меньше "
              + MIN_SCENE_SIZE
              + " и не больше "
              + MAX_SCENE_SIZE);
    }
    this.size = size;

    state = State.INITIALIZED;
  }

  public void appendCharacterToRandomPosition(Character character) {
    if (state != State.INITIALIZED) {
      throw new RuntimeException("Невозможно добавить новых персонажей т.к. сцена уже запущена");
    }

    if (characters.containsValue(character)) {
      throw new IllegalArgumentException("Персонаж уже на сцене: " + character);
    }

    boolean successfulAppend = false;
    for (int i = 0; i < MAX_SCENE_SIZE; i++) {
      int potentialPosition = ThreadLocalRandom.current().nextInt(0, this.size);
      if (!characters.containsKey(potentialPosition)) {
        characters.put(potentialPosition, character);
        successfulAppend = true;
        break;
      }
    }

    if (!successfulAppend) {
      for (int i = 0; i < MAX_SCENE_SIZE; i++) {
        if (!characters.containsKey(i)) {
          characters.put(i, character);
          successfulAppend = true;
          break;
        }
      }
    }

    if (!successfulAppend) {
      throw new RuntimeException("Не удалось найти свободную позицию на сцене для " + character);
    }
  }

  public Character getRandomOpponentFor(Character character) {
    Map<Integer, Character> opponents = getOpponentsFor(character);

    List<Character> opponentsList = new ArrayList<>(opponents.values());
    Character opponent = null;
    int countAttempt = 0;
    do {
      int potentialOpponentKey = ThreadLocalRandom.current().nextInt(0, opponentsList.size());

      try {
        opponent = opponentsList.get(potentialOpponentKey);
      } catch (IndexOutOfBoundsException e) {
        countAttempt++;
      }

      if (countAttempt > 10) {
        throw new RuntimeException("Что-то пошло не так");
      }
    } while (null == opponent);

    return opponent;
  }

  public Map<Integer, Character> getOpponentsFor(Character character) {
    return getOpponentsForInternal(character, (Map.Entry<Integer, Character> entry) -> true);
  }

  public Map<Integer, Character> getOpponentsFor(Character character, Character.Type type) {
    return getOpponentsForInternal(character, (Map.Entry<Integer, Character> entry) -> entry.getValue().getType() == type);
  }

  private Map<Integer, Character> getOpponentsForInternal(
      Character character, Predicate<Map.Entry<Integer, Character>> filterByType) {
    return characters.entrySet().stream()
        .filter((Map.Entry<Integer, Character> v) -> !v.getValue().isDead())
        .filter((Map.Entry<Integer, Character> item) -> !item.getValue().equals(character))
        .filter(filterByType)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  public void run() {
    state = State.STARTED;

    LOGGER.info("Начинается великая битва!");

    if (characters.isEmpty()) {
      LOGGER.info("Но похоже на нее ни кто не пришел");
      return;
    }

    for (int step = 1; getAliveCharacters().size() > 1; step++) {
      LOGGER.info("Шаг: " + step);

      LOGGER.charactersOnBattlefield(getAliveCharacters());

      for (Character character : getShuffledCharacters()) {
        if (!hasAnyOpponents() || character.isDead()) {
          break;
        }

        LOGGER.info(
            "--------------------- Ходит %s \"%s\" ---------------------",
            character.getType().toString().toLowerCase(), character.getName());

        Action action = character.produceAction(this);

        producer.produce(action);

        checkBodies();
      }

      LOGGER.newline();
    }

    showWinner();

    state = State.DONE;
  }

  private void showWinner() {
    List<Character> alive = getAliveCharacters();

    if (alive.size() != 1) {
      throw new RuntimeException("Что-то пошло не так");
    }

    Character winner = alive.get(0);

    LOGGER.winner(winner);
  }

  private List<Character> getAliveCharacters() {
    return characters.values().stream()
        .filter(character -> !character.isDead())
        .collect(Collectors.toList());
  }

  private void checkBodies() {
    for (Map.Entry<Integer, Character> entry : characters.entrySet()) {
      Character character = entry.getValue();

      if (character.isDead() && !deadCharacters.contains(character)) {
        deadCharacters.add(character);
        LOGGER.characterDead(character);
      }
    }
  }

  private List<Character> getShuffledCharacters() {
    return characters.entrySet().stream()
        .filter((Map.Entry<Integer, Character> v) -> !v.getValue().isDead())
        .sorted(Functions::randomComparator)
        .map(Map.Entry::getValue)
        .collect(Collectors.toList());
  }

  private boolean hasAnyOpponents() {
    return characters.entrySet().stream()
            .filter((Map.Entry<Integer, Character> v) -> !v.getValue().isDead())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            .size()
        > 1;
  }

  public int getIndexFor(Character character) {
    for (Map.Entry<Integer, Character> entry : characters.entrySet()) {
      if (entry.getValue().equals(character)) {
        return entry.getKey();
      }
    }

    throw new RuntimeException("Cant find index for " + character);
  }

  public Optional<Character> findNeighboredOpponentFor(Character character) {
    int characterIndex = getIndexFor(character);

    Map<Integer, Character> opponents = getOpponentsFor(character);

    int[] allowedNeighborIndexes = new int[] {characterIndex - 1, characterIndex + 1};

    for (int index : allowedNeighborIndexes) {
      if (opponents.containsKey(index)) {
        return Optional.of(opponents.get(index));
      }
    }

    return Optional.empty();
  }

  private enum State {
    INITIALIZED,
    STARTED,
    DONE
  }
}
