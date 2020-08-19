package data.classesForSerialization;

import org.serieznyi.serialization.serializer.annotation.Serialize;
import org.serieznyi.serialization.serializer.annotation.SerializeName;

import java.util.Objects;

@Serialize(typeName = "Некто")
public final class PersonWithLinkOnPerson {
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

  public PersonWithPrimitiveFieldsWithoutOverriddenNames friend;

  public PersonWithLinkOnPerson(PersonWithPrimitiveFieldsWithoutOverriddenNames friend) {
    this.friend = friend;
  }

  private PersonWithLinkOnPerson() {}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PersonWithLinkOnPerson that = (PersonWithLinkOnPerson) o;
    return age == that.age
        && phone == that.phone
        && height == that.height
        && Float.compare(that.rating, rating) == 0
        && hasChildes == that.hasChildes
        && favoriteChar == that.favoriteChar
        && firstName.equals(that.firstName)
        && friend.equals(that.friend);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, age, phone, height, rating, hasChildes, favoriteChar, friend);
  }

  @Override
  public String toString() {
    return "PersonWithLinkOnPerson{"
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
        + ", friend="
        + friend
        + '}';
  }
}
