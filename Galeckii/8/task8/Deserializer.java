package task8;

import task8.annotations.XmlIgnore;

import java.lang.reflect.Field;

public class Deserializer {

    public static void deserialize(String xmlString, Class clazz) {
        StringBuilder sb = new StringBuilder();
        String className = clazz.getName();
        className = className.substring(className.indexOf(".")+1);
        sb.append(className).append("{");

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                sb.append(field.getName() + "=null");
                continue;
            }
            String openTag = "<" + Util.getFieldName(field) + ">";
            String closeTag = "</" + Util.getFieldName(field) + ">";
            String fieldValue = xmlString.substring(xmlString.indexOf(openTag) + openTag.length(), xmlString.indexOf(closeTag));

            sb.append(field.getName() + "=\"" + fieldValue + "\",");
        }

        sb.append("}");
        System.out.println(sb.toString());
    }
}
