package BattleGame.Serializer;

import BattleGame.Actions.Action;
import BattleGame.Actions.MagicianAction;
import BattleGame.Actions.MonsterAction;
import BattleGame.Character;
import BattleGame.Exceptions.DeserializeException;
import BattleGame.Magician;
import BattleGame.Monster;
import BattleGame.Spells.*;
import BattleGame.annotations.XmlIgnore;
import BattleGame.annotations.XmlName;
import BattleGame.annotations.XmlTypeName;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import static BattleGame.Scene.MAX_NUM_OF_BATTLERS;

public class Deserializer {
    public static Character deserializeCharacter(String xmlString, Class<? extends Character> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Character deserializeObject = clazz.getConstructor().newInstance();

        Field[] fieldsSuper = clazz.getSuperclass().getDeclaredFields();
        for (Field field : fieldsSuper) {
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length == 0) {
                continue;
            }
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            String fieldName = getFieldName(field);
            String openTag = "<" + fieldName + ">";
            String closeTag = "</" + fieldName + ">";
            String fieldValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));
            field.setAccessible(true);
            if (field.getType().isAssignableFrom(int.class)) {
                int i = Integer.parseInt(fieldValue);
                field.setInt(deserializeObject, i);
            } else if (field.getType().isAssignableFrom(boolean.class)) {
                boolean b = Boolean.parseBoolean(fieldValue);
                field.setBoolean(deserializeObject, b);
            } else if (fieldValue.equals("Цели")) {
                field.set(deserializeObject, deserializeCharacterArray(fieldValue));
            }else {
                field.set(deserializeObject, fieldValue);
            }
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length == 0) {
                continue;
            }
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            String fieldName = getFieldName(field);
            String openTag = "<" + fieldName + ">";
            String closeTag = "</" + fieldName + ">";
            String fieldValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));
            field.setAccessible(true);
            if (field.getType().isAssignableFrom(int.class)) {
                int i = Integer.parseInt(fieldValue);
                field.setInt(deserializeObject, i);
            } else if (field.getType().isAssignableFrom(boolean.class)) {
                boolean b = Boolean.parseBoolean(fieldValue);
                field.setBoolean(deserializeObject, b);
            } else {
                field.set(deserializeObject, fieldValue);
            }
        }
        return deserializeObject;
    }

    public static void deserializeCharacter(String xmlString, Class<? extends Character> clazz, Character[] battlers) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Character deserializeObject = deserializeCharacter(xmlString, clazz);
        battlers[deserializeObject.getPosition()] = deserializeObject;
    }

    public static Character[] deserializeCharacterArray(String xmlString) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Character[] deserializeObject = new Character[MAX_NUM_OF_BATTLERS];
        while (!xmlString.equals("\n"))
        {
            String openTag = "<";
            String closeTag = ">";
            String typeName = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));
            openTag = "<" + typeName + ">";
            closeTag = "</" + typeName + ">";
            String xmlClassValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));

            if (typeName.equals("Маг")) {
                deserializeCharacter(xmlClassValue, Magician.class, deserializeObject);
            } else if (typeName.equals("Монстр")) {
                deserializeCharacter(xmlClassValue, Monster.class, deserializeObject);
            } else {
                System.out.println("Ошибка--------------------------------------------------------------------------------");
                deserializeCharacter(xmlClassValue, Character.class, deserializeObject);
            }
            xmlString = xmlString.substring(xmlString.indexOf(openTag) + openTag.length() +  xmlClassValue.length() + closeTag.length());
        }

        return deserializeObject;
    }

    public static void deserializeAction(String xmlString, Class<? extends Action> clazz,
                                         Collection<? super Action> actions)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Action deserializeObject = clazz.getConstructor().newInstance();

        Field[] fieldsSuper = clazz.getSuperclass().getDeclaredFields();
        for (Field field : fieldsSuper) {
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length == 0) {
                continue;
            }
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            String fieldName = getFieldName(field);
            String openTag = "<" + fieldName + ">";
            String closeTag = "</" + fieldName + ">";
            String fieldValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));
            field.setAccessible(true);
            if (field.getType().isAssignableFrom(int.class)) {
                int i = Integer.parseInt(fieldValue);
                field.setInt(deserializeObject, i);
            } else if (field.getType().isAssignableFrom(boolean.class)) {
                boolean b = Boolean.parseBoolean(fieldValue);
                field.setBoolean(deserializeObject, b);
            }else if (fieldName.equals("Атакующий")) {
                field.set(deserializeObject, deserializeTargetArray(fieldValue)[0]);
            }else {
                field.set(deserializeObject, fieldValue);
            }
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length == 0) {
                continue;
            }
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            String fieldName = getFieldName(field);
            String openTag = "<" + fieldName + ">";
            String closeTag = "</" + fieldName + ">";
            String fieldValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));
            field.setAccessible(true);
            if (field.getType().isAssignableFrom(int.class)) {
                int i = Integer.parseInt(fieldValue);
                field.setInt(deserializeObject, i);
            } else if (field.getType().isAssignableFrom(boolean.class)) {
                boolean b = Boolean.parseBoolean(fieldValue);
                field.setBoolean(deserializeObject, b);
            } else if (fieldName.equals("Цель")) {
                Character targetCh = deserializeTargetArray(fieldValue)[0];
                field.set(deserializeObject, targetCh);
            }else if (fieldName.equals("Цели")) {
                field.set(deserializeObject, deserializeTargetArray(fieldValue));
            }else if (fieldName.equals("Заклинание_атаки")) {
                field.set(deserializeObject, deserializeSpell(fieldValue));
            }else {
                field.set(deserializeObject, fieldValue);
            }
        }
        actions.add(deserializeObject);
    }

    public static Collection<? super Action> deserializeActionCollection(String xmlString)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Collection<? super Action> deserializeObject = new ArrayList<>();

        while (!xmlString.equals("\n"))
        {
            String openTag = "<";
            String closeTag = ">";
            String typeName = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));
            openTag = "<" + typeName + ">";
            closeTag = "</" + typeName + ">";
            String xmlClassValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));

            if (typeName.equals("Ход_мага")) {
                deserializeAction(xmlClassValue, MagicianAction.class, deserializeObject);
            } else if (typeName.equals("Ход_монстра")) {
                deserializeAction(xmlClassValue, MonsterAction.class, deserializeObject);
            } else {
                System.out.println("Ошибка--------------------------------------------------------------------------------");
                deserializeAction(xmlClassValue, Action.class, deserializeObject);
            }
            xmlString = xmlString.substring(xmlString.indexOf(openTag) + openTag.length() +  xmlClassValue.length() + closeTag.length());
        }

        return deserializeObject;
    }

    public static Spell deserializeSpell(String xmlString) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Spell deserializeObject = null;

        Field[] fieldsSuper = Spell.class.getDeclaredFields();
        for (Field field : fieldsSuper) {
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length == 0) {
                continue;
            }
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            String fieldName = getFieldName(field);
            String openTag = "<" + fieldName + ">";
            String closeTag = "</" + fieldName + ">";
            String fieldValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));
            switch (fieldValue) {
                case "Цепная молния" -> deserializeObject = ChainLighting.class.getConstructor().newInstance();
                case "Изгнание монстров" -> deserializeObject = ExpellingMonsters.class.getConstructor().newInstance();
                case "Огненное касание" -> deserializeObject = FieryTouch.class.getConstructor().newInstance();
                case "Исцеление" -> deserializeObject = Healing.class.getConstructor().newInstance();
                case "Молния" -> deserializeObject = Lightning.class.getConstructor().newInstance();
                case "Мигрень" -> deserializeObject = Migraine.class.getConstructor().newInstance();
                case "Стена огня" -> deserializeObject = WallOfFire.class.getConstructor().newInstance();
                default -> {
                    try {
                        throw new DeserializeException();
                    } catch (DeserializeException e) {
                        e.getMessage();
                    }
                }
            }
        }
        return deserializeObject;
    }

    public static Character[] deserializeTargetArray(String xmlString) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Character[] deserializeObject = new Character[MAX_NUM_OF_BATTLERS];
        int count = 0;

        while (!xmlString.equals("\n"))
        {
            String openTag = "<";
            String closeTag = ">";
            String typeName = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));
            openTag = "<" + typeName + ">";
            closeTag = "</" + typeName + ">";
            String xmlClassValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));

            if (typeName.equals("Маг")) {
                deserializeObject [count++] = deserializeCharacter(xmlClassValue, Magician.class);
            } else if (typeName.equals("Монстр")) {
                deserializeObject [count++] = deserializeCharacter(xmlClassValue, Monster.class);
            } else {
                try {
                    throw new DeserializeException();
                } catch (DeserializeException e) {
                    e.getMessage();
                }
            }
            xmlString = xmlString.substring(xmlString.indexOf(openTag) + openTag.length() +  xmlClassValue.length() + closeTag.length());
        }
        return deserializeObject;
    }

    public static String getFieldName(Field field) {
        final XmlName annotation = field.getAnnotation(XmlName.class);
        if (annotation == null) {
            return field.getName();
        }
        final String value = annotation.fieldName();
        if (!value.isEmpty()) {
            return value;
        }
        return field.getName();
    }

    public static String getTypeName(Class<?> clazz) {
        final XmlTypeName annotation = clazz.getAnnotation(XmlTypeName.class);
        if (annotation == null) {
            return clazz.getName();
        }
        final String value = annotation.typeName();
        if (!value.isEmpty()) {
            return value;
        }
        return clazz.getName();
    }
}
