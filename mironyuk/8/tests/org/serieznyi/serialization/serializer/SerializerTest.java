package org.serieznyi.serialization.serializer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.serieznyi.serialization.serializer.classesForSerialization.Person;
import org.serieznyi.serialization.serializer.exception.FormatNotSupportedException;


class SerializerTest {

  private Serializer serializer;

  private static Object[] objectsForSerialize() {
    return new Object[] {
      new Person("Василий", 23, "password123")
    };
  }

  @BeforeEach
  void setUp() {
    serializer = new Serializer();
  }

  @ParameterizedTest
  @MethodSource("objectsForSerialize")
  void serialize(Object obj) throws FormatNotSupportedException {

    String xml = serializer.serialize(obj, Serializer.Format.XML);

    serializer.deserialize(xml, Object.class, Serializer.Format.XML);
  }
}