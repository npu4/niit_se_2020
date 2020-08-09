package org.serieznyi.serialization.serializer.encoder;

import data.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.serieznyi.serialization.serializer.value.ObjectValue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlEncoderTest {
  final XmlEncoder encoder = new XmlEncoder();

  private static List<Pair<ObjectValue, String>> objects() {
    List<Pair<ObjectValue, String>> data = new ArrayList<>();

    data.add(
        new Pair<>(
            new ObjectValue("person"),
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" +
            "<person/>"));

    data.add(
        new Pair<>(
            new ObjectValue("person").addNullValue("age"),
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" +
                "<person>" +
                "<age>NULL</age>" +
            "</person>"));

    data.add(
        new Pair<>(
            new ObjectValue("person")
                .addPrimitiveValue("name", "Maxim")
                .addPrimitiveValue("marred", "true"),
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" +
              "<person>" +
              "<marred>true</marred>"+
              "<name>Maxim</name>" +
            "</person>"));

    ObjectValue friend =
        new ObjectValue("person")
            .addPrimitiveValue("name", "Vasia")
            .addPrimitiveValue("marred", "false");

    data.add(
        new Pair<>(
            new ObjectValue("person")
                .addPrimitiveValue("name", "Maxim")
                .addPrimitiveValue("marred", "true")
                .addObjectValue("friend", friend),
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" +
                    "<person>" +
                      "<friend>" +
                        "<person>" +
                        "<marred>false</marred>" +
                        "<name>Vasia</name>" +
                        "</person>" +
                      "</friend>" +
                      "<marred>true</marred>" +
                      "<name>Maxim</name>" +
                    "</person>"));

    return data;
  }

  @ParameterizedTest
  @MethodSource("objects")
  void testWhatEncodingIsCorrect(Pair<ObjectValue, String> pair) {
    ObjectValue objectValue = pair.getFirst();
    String xml = pair.getSecond();

    String encodedObjectValue = encoder.encode(objectValue);

    assertEquals(xml, encodedObjectValue, "Кодированная строка верна");
  }

  @ParameterizedTest
  @MethodSource("objects")
  void testWhatEncodedObjectEqualsDecoded(Pair<ObjectValue, String> pair) {
    ObjectValue objectValue = pair.getFirst();

    String encodedObjectValue = encoder.encode(objectValue);

    ObjectValue decodedObjectValue = encoder.decode(encodedObjectValue);

    assertEquals(objectValue, decodedObjectValue, "Декодированный объект равен кодированному");
  }
}
