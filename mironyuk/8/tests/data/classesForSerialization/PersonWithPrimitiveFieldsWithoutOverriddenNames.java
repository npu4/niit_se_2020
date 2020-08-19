package data.classesForSerialization;

import org.serieznyi.serialization.serializer.annotation.Serialize;

import java.util.Objects;

@Serialize()
public final class PersonWithPrimitiveFieldsWithoutOverriddenNames {
  public String firstName = "Max";

  public int age = 12;

  public long phone = 789318064471L;

  public short height = 172;

  public float rating = 12.5F;

  public boolean hasChildes = false;

  public char favoriteChar = 'A';

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PersonWithPrimitiveFieldsWithoutOverriddenNames that =
        (PersonWithPrimitiveFieldsWithoutOverriddenNames) o;
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
    return "PersonWithPrimitiveFieldsWithoutOverriddenNames{"
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
