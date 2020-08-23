package org.serieznyi.FightOfWizards.actionProducer;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.Snapshot;
import org.serieznyi.FightOfWizards.action.Action;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.util.Assert;
import org.serieznyi.serialization.XmlPrettyFormatter;
import org.serieznyi.serialization.serializer.Serializer;
import org.serieznyi.serialization.serializer.exception.FormatNotSupportedException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.*;

public class ReplayActionProducer implements ObjectsProducer {
    private final Path replayPath;
    private final Serializer serializer;
    private boolean initialized = false;
    private Snapshot snapshot;
    private Iterator<Action> actionIterator;

    public ReplayActionProducer(Path replayFilePath) {
        Assert.requirePathExists(replayFilePath, "Файл не существует: " + replayFilePath);
        Assert.requirePathEnds(replayFilePath, ".xml", "Неверный файл. Должен быть XML");
        replayPath = replayFilePath;

        serializer = new Serializer();
    }

    private void initialise() {
        if (initialized) {
            return;
        }

        try(Reader reader = new FileReader(replayPath.toFile())) {
            StringBuilder xmlBuilder = new StringBuilder();

            int character;
            while ((character = reader.read()) != -1) {
                xmlBuilder.append((char) character);
            }

            XmlPrettyFormatter formatter = new XmlPrettyFormatter();

            String xml = formatter.fromPrettyView(xmlBuilder.toString());

            snapshot = (Snapshot) serializer.deserialize(xml, Snapshot.class, Serializer.Format.XML);

            resetCharacters();
        } catch (IOException|FormatNotSupportedException e) {
            throw new RuntimeException(e);
        }

        actionIterator = snapshot.getActions().iterator();

        initialized = true;
    }

    private void resetCharacters() {
        try {
            resetCharactersHealth();

            resetCharacterLinkInActions();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void resetCharacterLinkInActions() throws IllegalAccessException {
        for (Action action : snapshot.getActions()) {
            resetCharacterLink(action);
        }
    }

    private void resetCharacterLink(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();

        Map<String, Field> fields = getFields(clazz);

        for (Map.Entry<String, Field> entry : fields.entrySet()) {
            Field field = entry.getValue();
            field.setAccessible(true);
            Object fieldValue = field.get(object);

            if (fieldValue instanceof Character) {
                field.set(object, getRealCharacterLinkFor((Character) fieldValue));
            } else if (fieldValue instanceof Collection) {
                resetCharacterLinkInCollection(fieldValue);
            } else if (fieldValue instanceof Action) {
                resetCharacterLink(fieldValue);
            }
        }
    }

    private void resetCharacterLinkInCollection(Object fieldValue) throws IllegalAccessException {
        Collection collection = (Collection<?>) fieldValue;

        if (collection.isEmpty()) {
            return;
        }

        Optional<?> first = collection.stream().findFirst();

        if (first.get() instanceof Character) {
            Object[] collectionData = collection.toArray();
            collection.clear();
            for (Object o : collectionData) {
                collection.add(getRealCharacterLinkFor((Character) o));
            }
        } else {
            for (Object o : collection) {
                resetCharacterLink(o);
            }
        }
    }

    private Character getRealCharacterLinkFor(Character character)
    {
        for (Map.Entry<Integer, Character> entry : snapshot.getCharacters().entrySet()) {
            Character fixedCharter = entry.getValue();

            if (fixedCharter.getName().equals(character.getName())) {
                return fixedCharter;
            }
        }

        throw new RuntimeException("Не могу найти ссылку для персонажа: " + character);
    }

    private void resetCharactersHealth() throws IllegalAccessException {
        for (Map.Entry<Integer, Character> entry : snapshot.getCharacters().entrySet()) {
            Character character = entry.getValue();
            Class<? extends Character> clazz = character.getClass();
            Map<String, Field> fields = getFields(clazz);

            Field health = fields.get("health");
            health.setAccessible(true);

            Field initialHealth = fields.get("initialHealth");
            initialHealth.setAccessible(true);

            health.set(character, initialHealth.get(character));
        }
    }

    private Map<String, Field> getFields(Class<?> clazzArg) {
        Map<String, Field> fields = new HashMap<>();

        Class<?> clazz = clazzArg;

        do {
            for (Field field : clazz.getDeclaredFields()) {
                fields.put(field.getName(), field);
            }
        } while ((clazz = clazz.getSuperclass()) != null && !clazz.equals(Object.class));

        return fields;
    }

    @Override
    public Set<Character> getCharacters(Scene scene, int count) {
        initialise();

        return new HashSet<>(snapshot.getCharacters().values());
    }

    @Override
    public Action nextAction(Scene scene) {
        initialise();

        if (!actionIterator.hasNext()) {
            return null;
        }

        return actionIterator.next();
    }
}
