package com.jsonserializer;

import java.lang.reflect.Field;

public class JsonSerializer {




    public static String getJsonString(Object o) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder("{");


        int fieldCount = 0;

        final Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonIgnore.class)){
                continue;
            }

            field.setAccessible(true);
            String prefix = "";
            String suffix = "";
            if (field.getType() == String.class) {
                prefix = "\"";
                suffix = "\"";
            }

            final String name = getFieldName(field);
            sb.append(name + ":" + prefix + field.get(o) + suffix);


            if (fieldCount++ < fields.length - 1) {
                sb.append(",");
            }
        }


        sb.append("}");
        return sb.toString();
    }

    private static String getFieldName(Field field) {

        if (field.isAnnotationPresent(JsonField.class)) {
            final JsonField annotation = field.getAnnotation(JsonField.class);
            return annotation.jsonName();

        }

        return field.getName();
    }
}
