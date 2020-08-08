package org.serieznyi.serialization.serializer.classesForSerialization;

import org.serieznyi.serialization.serializer.annotation.SerializeIgnoreField;
import org.serieznyi.serialization.serializer.annotation.SerializeName;
import org.serieznyi.serialization.serializer.annotation.Serialize;

@Serialize(typeName = "Человек")
public class Person {
    @SerializeName(value = "Имя")
    String firstName;

    @SerializeName(value = "Возраст")
    double age;

    @SerializeName(value = "Возраст")
    double age;

    @SerializeIgnoreField
    String password;

    public Person(String firstName, int age, String password) {
        this.firstName = firstName;
        this.age = age;
        this.password = password;
    }
}