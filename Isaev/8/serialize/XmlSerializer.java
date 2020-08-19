package serialize;

import annotations.XmlIgnore;
import annotations.XmlName;
import annotations.XmlTypeName;

import java.lang.reflect.Field;
import java.util.Collection;

public class XmlSerializer {

    public static String xmlSerialize(Collection<?> objects) throws IllegalAccessError, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        for (Object object : objects) {
            sb.append(getXmlString(object));
        }
        return sb.toString();

    }

    private static String getXmlString(Object object) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append(typeOpen(typeName(object.getClass())));
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            field.setAccessible(true);
            String name = fieldName(field);
            sb.append(getXmlField(object, field, name));
        }
        sb.append(typeClose(typeName(object.getClass())));
        return sb.toString();

    }

    public static String typeOpen(String type) {
        return "<" + type + ">\n";
    }

    public static String typeClose(String type) {
        return "<" + type + "/>\n";
    }
    public static String fieldOpen(String field){
        return "<" + field + ">";
    }
    public static String fieldClose(String field){
        return "<" + field + "/>";
    }

    public static String getXmlField(Object object, Field field, String name) throws IllegalAccessException {
        return "    <" + name + ">" + field.get(object) + "<" + name + "/>\n";
    }

    public static String fieldName(Field field) {
        if (field.isAnnotationPresent(XmlName.class)) {
            XmlName fieldName = field.getAnnotation(XmlName.class);
            return fieldName.fieldName();
        }
        return null;
    }

    static String typeName(Class type) {
        if (type.isAnnotationPresent(XmlTypeName.class)) {
            XmlTypeName typeName = (XmlTypeName) type.getAnnotation(XmlTypeName.class);
            return typeName.typeName();
        }
        return null;
    }
}
