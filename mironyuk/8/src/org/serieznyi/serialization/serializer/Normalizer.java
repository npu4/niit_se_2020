package org.serieznyi.serialization.serializer;

import org.serieznyi.serialization.serializer.annotation.Serialize;
import org.serieznyi.serialization.serializer.annotation.SerializeIgnoreField;
import org.serieznyi.serialization.serializer.annotation.SerializeName;
import org.serieznyi.serialization.serializer.exception.NormalizerException;
import org.serieznyi.serialization.serializer.value.ObjectValue;
import org.serieznyi.serialization.serializer.value.Value;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class Normalizer {
  ObjectValue normalize(Object objectForNormalization) {
    Class<?> clazz = objectForNormalization.getClass();
    String typeName = getTypeName(clazz);
    boolean skipNull = isSkipNull(clazz);

    ObjectValue resultObject = new ObjectValue(typeName);

    for (Field declaredField : clazz.getDeclaredFields()) {
      declaredField.setAccessible(true);

      if (isIgnoredField(declaredField)) {
        continue;
      }

      try {
        Object fieldObject = declaredField.get(objectForNormalization);

        String fieldName = getFieldName(declaredField);

        if (isPrimitiveTypeField(declaredField)) {
          resultObject.addPrimitiveValue(fieldName, fieldObject.toString(), null);
        } else {
          if (fieldObject != null) {
            resultObject.addObjectValue(fieldName, normalize(fieldObject));
          } else if (fieldObject == null && !skipNull) {
            resultObject.addNullValue(fieldName);
          }
        }
      } catch (IllegalAccessException e) {
        throw new NormalizerException(e);
      }
    }

    return resultObject;
  }

  Object denormalize(ObjectValue value, Class<?> clazz) {
    try {
      return valueToObject(value, clazz);
    } catch (NoSuchMethodException
        | IllegalAccessException
        | InstantiationException
        | InvocationTargetException e) {
      throw new NormalizerException(e);
    }
  }

  private String getTypeName(Class<?> clazz) {
    Serialize serializeAnnotation = clazz.getAnnotation(Serialize.class);

    return serializeAnnotation != null ? serializeAnnotation.typeName() : clazz.getName();
  }

  private boolean isSkipNull(Class<?> clazz) {
    Serialize serializeAnnotation = clazz.getAnnotation(Serialize.class);

    return serializeAnnotation.skipNull();
  }

  private boolean isIgnoredField(Field declaredField) {
    return declaredField.isAnnotationPresent(SerializeIgnoreField.class);
  }

  private String getFieldName(Field declaredField) {
    SerializeName serializeName = declaredField.getAnnotation(SerializeName.class);

    return serializeName != null ? serializeName.value() : declaredField.getName();
  }

  private Object valueToObject(ObjectValue value, Class<?> clazz)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
          InstantiationException {
    Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();

    Object object = declaredConstructor.newInstance();

    for (Field declaredField : clazz.getDeclaredFields()) {
      declaredField.setAccessible(true);

      String fieldName = getFieldName(declaredField);

      Value<?> fieldValue = getFieldValue(fieldName, value);

      if (fieldValue != null) {
        declaredField.set(object, castValueTo(declaredField.getType(), fieldValue));
      }
    }

    return object;
  }

  private Object castValueTo(Class<?> declaredFieldType, Value<?> value)
      throws InvocationTargetException, NoSuchMethodException, InstantiationException,
          IllegalAccessException {
    Object result = null;

    if (value.getType() == Value.Type.PRIMITIVE) {
      result = castPrimitiveValue(declaredFieldType, value.getValue());
    } else if (value.getType() == Value.Type.OBJECT) {
      result = valueToObject((ObjectValue) value, declaredFieldType);
    }

    return result;
  }

  private Object castPrimitiveValue(Class<?> declaredFieldType, Object value) {
    Object result;

    if (declaredFieldType.equals(int.class)) {
      result = Integer.parseInt((String) value); // TODO
    } else {
      result = declaredFieldType.cast(value);
    }

    return result;
  }

  private Value<?> getFieldValue(String fieldName, ObjectValue value) {
    return value.getValue().get(fieldName);
  }

  private boolean isPrimitiveTypeField(Field field) {
    Class<?> type = field.getType();

    return type == float.class
        || type == int.class
        || type == short.class
        || type == String.class
        || type == double.class;
  }
}
