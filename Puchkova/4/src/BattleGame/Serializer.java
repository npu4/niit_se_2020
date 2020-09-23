package BattleGame;

import BattleGame.Spells.Spell;
import BattleGame.annotations.EnclosingTag;
import BattleGame.annotations.XmlName;
import BattleGame.annotations.XmlTypeName;

import java.lang.reflect.Field;

public class Serializer {
    public static String serializeCharacters (Character[] characters) throws IllegalAccessException {
        StringBuilder serializeObject = new StringBuilder();
        int i = 0;
        while (characters[i] == null) {
            i++;
        }
        EnclosingTag enclosingTag = characters[i].getClass().getSuperclass().getAnnotation(EnclosingTag.class);
        String tagName = enclosingTag.tagName();
        serializeObject.append("<").append(tagName).append("> \n");
        for (Character character : characters) {
            if (character != null) {
                XmlTypeName annotation = character.getClass().getAnnotation(XmlTypeName.class);
                String typeName = annotation.typeName();
                serializeObject.append("<").append(typeName).append("> \n");
                for (Field field : character.getClass().getSuperclass().getDeclaredFields()) {
                    XmlName fieldAnnotation = field.getAnnotation(XmlName.class);
                    if (fieldAnnotation != null) {
                        field.setAccessible(true);
                        serializeObject.append("\t<").append(fieldAnnotation.fieldName()).append(">")
                                .append(field.get(character).toString())
                                .append("</").append(fieldAnnotation.fieldName()).append(">\n");

                    }
                }
                for (Field field : character.getClass().getDeclaredFields()) {
                    XmlName fieldAnnotation = field.getAnnotation(XmlName.class);
                    if (fieldAnnotation != null) {
                        if (field.getType().isAssignableFrom(Spell[].class)) {
                            Spell[] spells = (Spell[]) field.get(character);
                            EnclosingTag enclosingTagSpells = spells[0].getClass().getSuperclass().getAnnotation(EnclosingTag.class);
                            String tagNameSpells = enclosingTagSpells.tagName();
                            serializeObject.append("\t\t<").append(tagNameSpells).append("> \n");
                            for (Spell spell : spells) {
                                XmlTypeName annotationSpells = spell.getClass().getSuperclass().getAnnotation(XmlTypeName.class);
                                String typeNameSpells = annotationSpells.typeName();
                                serializeObject.append("\t\t<").append(typeNameSpells).append("> \n");
                                for(Field fieldSpells : spell.getClass().getDeclaredFields()){
                                    XmlName fieldAnnotationSpells = fieldSpells.getAnnotation(XmlName.class);
                                    if(fieldAnnotationSpells != null){
                                        fieldSpells.setAccessible(true);
                                        serializeObject.append("\t\t\t<").append(fieldAnnotationSpells.fieldName()).append(">")
                                                .append(fieldSpells.get(spell).toString())
                                                .append("</").append(fieldAnnotationSpells.fieldName()).append(">\n");
                                    }
                                }
                                serializeObject.append("\t\t</").append(typeNameSpells).append("> \n");
                            }
                            serializeObject.append("\t\t</").append(tagNameSpells).append("> \n");
                        } else {
                            field.setAccessible(true);
                            serializeObject.append("\t<").append(fieldAnnotation.fieldName()).append(">")
                                    .append(field.get(character).toString())
                                    .append("</").append(fieldAnnotation.fieldName()).append(">\n");
                        }
                    }
                }
                serializeObject.append("</").append(typeName).append("> \n");
            }
        }
        serializeObject.append("</").append(tagName).append("> \n");
        return serializeObject.toString();
    }
}