import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public abstract class DeSerializator {

    public static String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        for (Object object : objects) {
            sb.append("<").append(getTypeName(object.getClass())).append(">\n");
            for (Field field : object.getClass().getDeclaredFields()) {
                if (!field.isAnnotationPresent(XmlIgnore.class)) {
                    field.setAccessible(true);
                    sb.append("\t");
                    sb.append("<").append(getFieldName(field)).append(">");
                    sb.append((field.get(object)));
                    sb.append("</").append(getFieldName(field)).append(">\n");
                }
            }
            sb.append("</").append(getTypeName(object.getClass())).append(">\n");
        }
        return sb.toString();
    }

    private static String getFieldName(Field field) {
        if (field.isAnnotationPresent(XmlName.class)) {
            final XmlName annotation = field.getAnnotation(XmlName.class);
            return annotation.value();
        }
        return field.getName();
    }

    private static String getTypeName(Class<?> clazz) {
        if (clazz.isAnnotationPresent(XmlTypeName.class)) {
            final XmlTypeName annotation = clazz.getAnnotation(XmlTypeName.class);
            return annotation.value();
        }
        return clazz.getSimpleName();
    }

    public static Collection<Object> deserealize(String serString, HashSet<Class> classes) throws IllegalAccessException, InstantiationException {
        Collection<Object> objects = new ArrayList<>();
        while (true) {
            Object newObject = new Object();
            Field[] objectFields = new Field[0];

            int sectionStart = serString.length();
            int sectionEnd = serString.length();

            boolean isObject = false;
            for (Class clazz : classes) {
                String name = getTypeName(clazz);
                String tagStart = "<" + name + ">";
                String tagEnd = "</" + name + ">";
                if (serString.indexOf(tagStart) < sectionStart && serString.contains(tagEnd)) {
                    sectionStart = serString.indexOf(tagStart);
                    sectionEnd = serString.indexOf(tagEnd) + tagEnd.length();

                    newObject = clazz.newInstance();
                    objectFields = clazz.getDeclaredFields();
                    isObject = true;
                }
            }
            if (!isObject) {
                break;
            }
            String oneSection = serString.substring(0, sectionEnd);
            serString = serString.substring(sectionEnd);
            for (Field field : objectFields) {
                String startTag = "<" + getFieldName(field) + ">";
                String endTag = "</" + getFieldName(field) + ">";
                if (!oneSection.contains(startTag) || !oneSection.contains(endTag)) {
                    continue;
                }
                field.setAccessible(true);
                String fieldValue = oneSection.substring(oneSection.indexOf(startTag) + startTag.length(),
                        oneSection.indexOf(endTag));
                if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                    field.set(newObject, Boolean.valueOf(fieldValue));
                    continue;
                }
                if (field.getType() == int.class || field.getType() == Integer.class) {
                    field.set(newObject, Integer.valueOf(fieldValue));
                    continue;
                }
                if (field.getType() == String.class) {
                    field.set(newObject, fieldValue);
                }
            }
            objects.add(newObject);
        }
        return objects;
    }
}