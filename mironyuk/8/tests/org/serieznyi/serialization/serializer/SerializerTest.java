package org.serieznyi.serialization.serializer;

import data.Pair;
import data.classesForSerialization.PersonWithLinkOnPerson;
import data.classesForSerialization.PersonWithPrimitiveFieldsWithOverriddenNames;
import data.classesForSerialization.PersonWithPrimitiveFieldsWithoutOverriddenNames;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.serieznyi.serialization.serializer.exception.FormatNotSupportedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class SerializerTest {
  private final Serializer serializer = new Serializer();

  private static List<Pair<Object, Serializer.Format>> objects() {
    List<Object> classesForSerialization =
        Arrays.asList(
            new PersonWithPrimitiveFieldsWithoutOverriddenNames(),
            new PersonWithPrimitiveFieldsWithOverriddenNames(),
            new PersonWithLinkOnPerson(new PersonWithPrimitiveFieldsWithoutOverriddenNames()));

    List<Pair<Object, Serializer.Format>> data = new ArrayList<>();

    for (Serializer.Format format : Serializer.Format.values()) {
      for (Object o : classesForSerialization) {
        data.add(new Pair<>(o, format));
      }
    }

    return data;
  }

  @ParameterizedTest
  @MethodSource("objects")
  void testWhatSerializingAndDeserializingIsSuccessful(Pair<Object, Serializer.Format> pair)
      throws FormatNotSupportedException {
    Object object = pair.getFirst();
    Serializer.Format format = pair.getSecond();

    String serializeResult = serializer.serialize(object, format);

    Object deserializedObject = serializer.deserialize(serializeResult, object.getClass(), format);

    assertEquals(object, deserializedObject, "Десериализованный объект равен сериализованному");
  }
}
