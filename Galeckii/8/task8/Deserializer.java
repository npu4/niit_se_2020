package task8;

import task8.annotations.XmlIgnore;

import java.lang.reflect.Field;

public class Deserializer {

    public static Object deserialize(String xmlString, Class<?> clazz) throws IllegalAccessException, InstantiationException {
        Object o = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            String openTag = "<" + Util.getFieldName(field) + ">";
            String closeTag = "</" + Util.getFieldName(field) + ">";
            String fieldValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));

            if (field.getType().isAssignableFrom(int.class)) {
                int i = Integer.parseInt(fieldValue);
                field.setInt(o, i);
            } else {
                field.set(o, fieldValue);
            }

        }

        return o;
    }

}
