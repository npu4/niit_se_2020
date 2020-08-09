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

  @SerializeName(value = "НомерТелефона")
  public long phone = 789318064471L;

  @SerializeName(value = "Рост")
  public short height = 172;

  @SerializeName(value = "СоциальныйРейтинг")
  public float rating;

  @SerializeName(value = "НаличиеДетей")
  public boolean hasChildes;

  @SerializeIgnoreField public String password;

  @SerializeName("БлизкийДруг")
  public Person friend;

  @SerializeName("ЛюбимыйСимвол")
  public char favoriteChar = 'A';

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
        + ", phone="
        + phone
        + ", height="
        + height
        + ", rating="
        + rating
        + ", hasChildes="
        + hasChildes
        + ", password='"
        + password
        + '\''
        + ", friend="
        + friend
        + ", favoriteChar="
        + favoriteChar
        + '}';
  }
}
