package data.classesForSerialization;

import org.serieznyi.serialization.serializer.annotation.Serialize;
import org.serieznyi.serialization.serializer.annotation.SerializeName;

import java.util.Objects;

@Serialize(typeName = "Некто")
public final class PersonWithPrimitiveFieldsWithOverriddenNames {
  @SerializeName("Имя")
  public String firstName = "Max";

  @SerializeName("Возраст")
  public int age = 12;

  @SerializeName("Телефон")
  public long phone = 789318064471L;

  @SerializeName("Рост")
  public short height = 172;

  @SerializeName("Рейтинг")
  public float rating = 12.5F;

  @SerializeName("НаличиеДетей")
  public boolean hasChildes = false;

  @SerializeName("ЛюбимыйСимвол")
  public char favoriteChar = 'A';

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PersonWithPrimitiveFieldsWithOverriddenNames that =
        (PersonWithPrimitiveFieldsWithOverriddenNames) o;
    return age == that.age
        && phone == that.phone
        && height == that.height
        && Float.compare(that.rating, rating) == 0
        && hasChildes == that.hasChildes
        && favoriteChar == that.favoriteChar
        && firstName.equals(that.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, age, phone, height, rating, hasChildes, favoriteChar);
  }

  @Override
  public String toString() {
    return "PersonWithPrimitiveFieldsWithOverriddenNames{"
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
        + ", favoriteChar="
        + favoriteChar
        + '}';
  }
}
