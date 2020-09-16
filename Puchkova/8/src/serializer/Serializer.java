package serializer;

import serializer.annotations.XmlName;
import serializer.annotations.XmlTypeName;

import java.lang.reflect.Field;
import java.util.Collection;

public class Serializer {
    public static String serialize(Collection<?> object) throws IllegalAccessException {
        StringBuilder serializeObject = new StringBuilder();
            for(Object obj : object){
                XmlTypeName annotation = obj.getClass().getAnnotation(XmlTypeName.class);
                String typeName = annotation.typeName();
                serializeObject.append("<").append(typeName).append("> \n");
                for(Field field : obj.getClass().getFields()){
                    XmlName fieldAnnotation = field.getAnnotation(XmlName.class);
                    if(fieldAnnotation != null){
                        serializeObject.append("\t<").append(fieldAnnotation.fieldName()).append(">")
                                .append(field.get(obj).toString())
                                .append("</").append(fieldAnnotation.fieldName()).append(">\n");
                    }
                }
                serializeObject.append("</").append(typeName).append("> \n");
            }
        return serializeObject.toString();
    }
}
