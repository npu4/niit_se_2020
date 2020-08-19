package org.serieznyi.serialization.serializer;

import data.classesForNormalization.*;
import data.classesForNormalization.supportedPrimitive.*;
import data.classesForNormalization.unsupportedPrimitive.ClassWithArray;
import data.classesForNormalization.unsupportedPrimitive.ClassWithCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.serieznyi.serialization.serializer.exception.NormalizerException;
import org.serieznyi.serialization.serializer.value.ObjectValue;
import org.serieznyi.serialization.serializer.value.Value;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

final class NormalizerTest {
  private final Normalizer normalizer = new Normalizer();

  private static List<Object> objectsWithPrimitiveTypes() {
    return Arrays.asList(
        new ClassWithPrimitiveInt(),
        new ClassWithPrimitiveWrappedInteger(),
        new ClassWithPrimitiveWrappedBoolean(),
        new ClassWithPrimitiveDouble(),
        new ClassWithPrimitiveFloat()
    );
  }

  private static List<Object> objectsWithNotSupportedBasicTypes() {
    return Arrays.asList(new ClassWithArray(), new ClassWithCollection());
  }

  @Test
  void testWhatFailIfSerializeAnnotationNotPresentInClass() {
    NormalizerException thrown =
        assertThrows(
            NormalizerException.class,
            () -> normalizer.normalize(new ClassWithoutSerializeAnnotation()),
            "Fail if annotation not present");

    assertEquals(thrown.getMessage(), "Class not marked by serialization annotation");
  }

  @Test
  void testWhatFailIfDefaultConstructorNotPresentInClass() {
    NormalizerException thrown =
        assertThrows(
            NormalizerException.class,
            () -> normalizer.normalize(new ClassWithoutDefaultConstructor("t1", "t2")),
            "Fail if default constructor not present");

    assertEquals(thrown.getMessage(), "Class doesn't have default constructor");
  }

  @ParameterizedTest
  @MethodSource("objectsWithPrimitiveTypes")
  void testWhatPrimitiveTypesNormalisationIsWork(Object object) {
    ObjectValue objectValue = normalizer.normalize(object);

    assertEquals(objectValue.getValue().size(), 1, "Объект содержит только одно значение");
    assertTrue(objectValue.getValue().containsKey("value"), "Значение лежит под правильным ключем");
    assertEquals(
        objectValue.getValue().get("value").getType(),
        Value.Type.PRIMITIVE,
        "У значения правильный тип");
  }

  @ParameterizedTest
  @MethodSource("objectsWithNotSupportedBasicTypes")
  void testWhatFailOnNotSupportedBasicTypes(Object object) {
    NormalizerException thrown =
        assertThrows(
            NormalizerException.class,
            () -> normalizer.normalize(object),
            "Fail on not supported basic types");

    assertEquals(thrown.getMessage(), "Class not marked by serialization annotation");
  }

  @Test
  void testWhatFieldNameOverrideIsWork() {
    ObjectValue objectValue = normalizer.normalize(new ClassWithOverriddenTypeAndFieldName());

    assertTrue(
        objectValue.getValue().containsKey("newFieldName"), "Значение лежит под правильным ключем");
  }

  @Test
  void testWhatTypeNameOverrideIsWork() {
    ObjectValue objectValue = normalizer.normalize(new ClassWithOverriddenTypeAndFieldName());

    assertEquals(
        objectValue.getTypeName(), "NewTypeName", "Название типа контейнера переопределено");
  }

  @Test
  void testWhatIgnoreFieldIsWork() {
    ObjectValue objectValue = normalizer.normalize(new ClassWithIgnoredField());

    assertEquals(objectValue.getValue().size(), 1, "В результате только одно поле");
    assertTrue(objectValue.getValue().containsKey("fieldOne"), "Не игнорируемое поле присутствует");
    assertFalse(
        objectValue.getValue().containsKey("fieldTwo"), "Поле которое игнорировали отсутсвует");
  }

  @Test
  void testWhatNullFieldsSkipIsWork() {
    ObjectValue objectValue = normalizer.normalize(new ClassWithNullSkipping());

    assertEquals(objectValue.getValue().size(), 1, "В результате только одно поле");
    assertTrue(
        objectValue.getValue().containsKey("fieldOne"), "Инициализированное поле присутствует");
    assertFalse(
        objectValue.getValue().containsKey("fieldTwo"), "Не инициализированное поле отсутсвует");
  }

  @Test
  void testWhaNormalisationWithNullFieldIsWork() {
    ObjectValue objectValue = normalizer.normalize(new ClassWithoutNullSkipping());

    assertEquals(objectValue.getValue().size(), 2, "В результате только одно поле");
    assertTrue(
        objectValue.getValue().containsKey("fieldTwo"), "Не инициализированное поле присуствует");
    assertEquals(
        objectValue.getValue().get("fieldTwo").getType(), Value.Type.NULL, "Значение типа NULL");
  }

  @Test
  void testWhaNormalisationForClassWithSuperClassIsWork() {
    ObjectValue objectValue = normalizer.normalize(new ClassWithSuperClass());

    assertEquals(objectValue.getValue().size(), 2, "Оба поля присутствуют");
    assertTrue(objectValue.getValue().containsKey("classField"), "Поле класса присутствует");
    assertTrue(objectValue.getValue().containsKey("fieldOfSuperClass"), "Поле суперскласа присутствует");

    assertEquals(new ClassWithSuperClass(), normalizer.denormalize(objectValue, ClassWithSuperClass.class));
  }
}
