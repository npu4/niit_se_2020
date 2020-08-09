package deserialize;

import annotations.XmlIgnore;
import serialize.XmlSerializer;

import java.lang.reflect.Field;

public class XmlDeserializer {

    public static Object deserialize(String xmlString, Class<?> newClass) throws IllegalAccessException, InstantiationException {
        Object object = newClass.newInstance();
        Field[] fields = newClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            String openField = XmlSerializer.fieldOpen(XmlSerializer.fieldName(field));
            String closeField = XmlSerializer.fieldClose(XmlSerializer.fieldName(field));
            String fieldValue = xmlString.substring(xmlString.indexOf(openField) + openField.length(), xmlString.indexOf(closeField));
            field.setAccessible(true);
            if (field.getType().isAssignableFrom(double.class)) {
                double number = Double.parseDouble(fieldValue);
                field.setDouble(object,number);
            } else {
                field.set(object, fieldValue);
            }
        }
        return object;
    }
}
