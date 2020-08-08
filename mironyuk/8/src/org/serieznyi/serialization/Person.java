package org.serieznyi.serialization;

import org.serieznyi.serialization.serializer.annotation.Serialize;
import org.serieznyi.serialization.serializer.annotation.SerializeIgnoreField;
import org.serieznyi.serialization.serializer.annotation.SerializeName;

@Serialize(typeName = "Человек")
public final class Person {
  @SerializeName(value = "Имя")
  public String firstName;

  @SerializeName(value = "Возраст")
  public int age;

  @SerializeIgnoreField public String password;

  @SerializeName("Друг")
  public Person friend;

  public Person() {}

  public Person(String firstName, int age, String password) {
    this.firstName = firstName;
    this.age = age;
    this.password = password;
  }

  @Override
  public String toString() {
    return "Person{"
        + "firstName='"
        + firstName
        + '\''
        + ", age="
        + age
        + ", password='"
        + password
        + '\''
        + ", friend="
        + friend
        + '}';
  }
}
