package BattleGame.Serializer;

import BattleGame.Character;
import BattleGame.Actions.Action;
import BattleGame.Spells.Spell;
import BattleGame.annotations.XmlName;
import BattleGame.annotations.XmlTypeName;

import java.lang.reflect.Field;
import java.util.Collection;

public class Serializer {
    public static String serializeCharacters(Character character) throws IllegalAccessException {
        StringBuilder serializeObject = new StringBuilder();
        if (character != null) {
            XmlTypeName annotation = character.getClass().getAnnotation(XmlTypeName.class);
            String typeName = annotation.typeName();
            serializeObject.append("<").append(typeName).append(">\n");
            for (Field field : character.getClass().getSuperclass().getDeclaredFields()) {
                XmlName fieldAnnotation = field.getAnnotation(XmlName.class);
                if (fieldAnnotation != null) {
                    field.setAccessible(true);
                    serializeObject.append("\t<").append(fieldAnnotation.fieldName()).append(">");
                    if (field.getType().isAssignableFrom(Character[].class)) {
                        Character[] characters = (Character[]) field.get(character);
                        serializeObject.append("\n").append(serializeCharactersArray(characters));
                    } else {
                        serializeObject.append(field.get(character).toString());
                    }
                    serializeObject.append("</").append(fieldAnnotation.fieldName()).append(">\n");
                }
            }
            for (Field field : character.getClass().getDeclaredFields()) {
                XmlName fieldAnnotation = field.getAnnotation(XmlName.class);
                if (fieldAnnotation != null) {
                    field.setAccessible(true);
                    serializeObject.append("\t<").append(fieldAnnotation.fieldName()).append(">");
                    if (field.getType().isAssignableFrom(Spell[].class)) {
                        Spell[] spells = (Spell[]) field.get(character);
                        serializeObject.append("\n").append(serializeSpellsArray(spells));
                    } else {
                        serializeObject.append(field.get(character).toString());
                    }
                    serializeObject.append("</").append(fieldAnnotation.fieldName()).append(">\n");
                }
            }
            serializeObject.append("</").append(typeName).append(">\n");
        }
        return serializeObject.toString();
    }

    public static String serializeCharactersArray(Character[] characters) throws IllegalAccessException {
        StringBuilder serializeObject = new StringBuilder();
        for (Character character : characters) {
            serializeObject.append(serializeCharacters(character));
        }
        return serializeObject.toString();
    }

    public static String serializeActions(Collection<? super Action> actions) throws IllegalAccessException {
        StringBuilder serializeObject = new StringBuilder();
        for (Object action : actions) {
            if (action != null) {
                XmlTypeName annotation = action.getClass().getAnnotation(XmlTypeName.class);
                String typeName = annotation.typeName();
                serializeObject.append("<").append(typeName).append(">\n");
                for (Field field : action.getClass().getSuperclass().getDeclaredFields()) {
                    XmlName fieldAnnotation = field.getAnnotation(XmlName.class);
                    if (fieldAnnotation != null) {
                        field.setAccessible(true);
                        serializeObject.append("\t<").append(fieldAnnotation.fieldName()).append(">");
                        if (field.getType().isAssignableFrom(Character.class)) {
                            Character characters = (Character) field.get(action);
                            serializeObject.append("\n").append(serializeCharacters(characters));
                        } else {
                            serializeObject.append(field.get(action).toString());
                        }
                        serializeObject.append("</").append(fieldAnnotation.fieldName()).append(">\n");
                    }
                }
                for (Field field : action.getClass().getDeclaredFields()) {
                    XmlName fieldAnnotation = field.getAnnotation(XmlName.class);
                    if (fieldAnnotation != null) {
                        serializeObject.append("\t<").append(fieldAnnotation.fieldName()).append(">");
                        field.setAccessible(true);
                        if (field.getType().isAssignableFrom(Character[].class)) {
                            Character[] characters = (Character[]) field.get(action);
                            serializeObject.append("\n").append(serializeCharactersArray(characters));
                        } else if (field.getType().isAssignableFrom(Spell.class)) {
                            Spell spell = (Spell) field.get(action);
                            serializeObject.append("\n").append(serializeSpells(spell));
                        } else if (field.getType().isAssignableFrom(Character.class)) {
                            Character characters = (Character) field.get(action);
                            serializeObject.append("\n").append(serializeCharacters(characters));
                        } else {
                            serializeObject.append(field.get(action).toString());
                        }
                        serializeObject.append("</").append(fieldAnnotation.fieldName()).append(">\n");
                    }
                }
                serializeObject.append("</").append(typeName).append(">\n");
            }
        }
        return serializeObject.toString();
    }

    public static String serializeSpells(Spell spell) throws IllegalAccessException {
        StringBuilder serializeObject = new StringBuilder();
        XmlTypeName annotationSpells = spell.getClass().getSuperclass().getAnnotation(XmlTypeName.class);
        String typeNameSpells = annotationSpells.typeName();
        serializeObject.append("\t\t<").append(typeNameSpells).append(">\n");
        for (Field fieldSpells : spell.getClass().getDeclaredFields()) {
            XmlName fieldAnnotationSpells = fieldSpells.getAnnotation(XmlName.class);
            if (fieldAnnotationSpells != null) {
                fieldSpells.setAccessible(true);
                serializeObject.append("\t\t\t<").append(fieldAnnotationSpells.fieldName()).append(">")
                        .append(fieldSpells.get(spell).toString())
                        .append("</").append(fieldAnnotationSpells.fieldName()).append(">\n");
            }
        }
        serializeObject.append("\t\t</").append(typeNameSpells).append(">\n");
        return serializeObject.toString();
    }

    public static String serializeSpellsArray(Spell[] spells) throws IllegalAccessException {
        StringBuilder serializeObject = new StringBuilder();
        for (Spell spell : spells) {
            serializeObject.append(serializeSpells(spell));
        }
        return serializeObject.toString();
    }
}