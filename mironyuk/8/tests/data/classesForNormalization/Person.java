package data.classesForNormalization;

import org.serieznyi.serialization.serializer.annotation.Serialize;
import org.serieznyi.serialization.serializer.annotation.SerializeIgnoreField;
import org.serieznyi.serialization.serializer.annotation.SerializeName;

@Serialize(typeName = "Человек")
public class Person {
  @SerializeName(value = "Имя")
  String firstName;

  @SerializeName(value = "Возраст")
  double age;

  @SerializeIgnoreField String password;

  public Person(String firstName, int age, String password) {
    this.firstName = firstName;
    this.age = age;
    this.password = password;
  }
}
