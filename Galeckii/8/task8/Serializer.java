package task8;

import task8.annotations.XmlIgnore;

import java.lang.reflect.Field;
import java.util.Collection;

public class Serializer {
    public static String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();

        for (Object object : objects) {
            sb.append(serializeObject(object));
        }

        return sb.toString();
    }

    private static String serializeObject(Object o) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(Util.getClassName(o.getClass())).append(">\n");

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }

            field.setAccessible(true);
            String name = Util.getFieldName(field);
            sb.append("\t<" + name + ">" + field.get(o) + "</" + name + ">\n");
        }
        sb.append("</" + Util.getClassName(o.getClass()) + ">\n");
        return sb.toString();
    }
}
