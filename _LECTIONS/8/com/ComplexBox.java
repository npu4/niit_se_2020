package com;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ComplexBox <T> {
    List<Object> content;
    Map<String, Integer> description;


    public ComplexBox(T content, List<String> description) {
       // this.content = content;
       // this.description = description;
    }


    public static void main(String[] args) throws NoSuchFieldException {
        final Class<ComplexBox> complexBoxClass = ComplexBox.class;
        final Field description = complexBoxClass.getDeclaredField("content");
        final Type genericType = description.getGenericType();


        if (genericType instanceof ParameterizedType) {
            System.out.println(Arrays.toString(((ParameterizedType) genericType).getActualTypeArguments()));
        }
    }
}
