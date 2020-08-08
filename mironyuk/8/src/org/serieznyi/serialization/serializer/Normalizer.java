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

    if (!isNormalizationSupported(clazz)) {
      throw NormalizerException.fromMessage("Class not marked by serialization annotation");
    }

    if (!isHasDefaultConstructor(clazz)) {
      throw NormalizerException.fromMessage("Class doesn't have default constructor");
    }

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

        if (fieldObject == null) {
          if (!skipNull) {
            resultObject.addNullValue(fieldName);
          }
        } else if (isPrimitiveTypeField(declaredField)) {
          resultObject.addPrimitiveValue(fieldName, fieldObject.toString());
        } else {
          resultObject.addObjectValue(fieldName, normalize(fieldObject));
        }
      } catch (IllegalAccessException e) {
        throw new NormalizerException(e);
      }
    }

    return resultObject;
  }

  private boolean isHasDefaultConstructor(Class<?> clazz) {
    for (Constructor<?> declaredConstructor : clazz.getDeclaredConstructors()) {
      if (declaredConstructor.getParameterCount() == 0) {
        return true;
      }
    }

    return false;
  }

  private boolean isNormalizationSupported(Class<?> clazz) {
    return clazz.isAnnotationPresent(Serialize.class);
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

    String typeName = clazz.getName();

    if (serializeAnnotation != null && !serializeAnnotation.typeName().isEmpty()) {
      typeName = serializeAnnotation.typeName();
    }

    return typeName;
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

    if (declaredFieldType.equals(short.class)) {
      result = Short.parseShort((String) value);
    } else if (declaredFieldType.equals(int.class)) {
      result = Integer.parseInt((String) value);
    } else if (declaredFieldType.equals(long.class)) {
      result = Long.parseLong((String) value);
    } else if (declaredFieldType.equals(float.class)) {
      result = Float.parseFloat((String) value);
    } else if (declaredFieldType.equals(double.class)) {
      result = Double.parseDouble((String) value);
    } else if (declaredFieldType.equals(boolean.class)) {
      result = Boolean.parseBoolean((String) value);
    } else if (declaredFieldType.equals(char.class)) {
      result = ((String) value).charAt(0);
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

    return type == short.class
        || type == int.class
        || type == long.class
        || type == float.class
        || type == double.class
        || type == String.class
        || type == boolean.class
        || type == char.class;
  }
}
