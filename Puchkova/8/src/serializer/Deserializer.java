package serializer;

import serializer.annotations.XmlIgnore;
import serializer.annotations.XmlName;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Deserializer {
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


    public static Object deserialize(String xmlString, Class<?> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object deserializeObject = clazz.getConstructor().newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length == 0){
                continue;
            }
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            String fieldName = getFieldName(field);
            String openTag = "<" + fieldName + ">";
            String closeTag = "</" + fieldName + ">";
            String fieldValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));

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
}
