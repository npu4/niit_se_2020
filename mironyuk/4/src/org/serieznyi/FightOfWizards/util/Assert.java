package org.serieznyi.FightOfWizards.util;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Objects;

public final class Assert {
  private Assert() {}

  public static void requireNotEmptyString(String str) {
    Objects.requireNonNull(str);

    if (str.isEmpty()) {
      throw new IllegalArgumentException("Строка не может быть пустой");
    }
  }

  public static void requireNotNull(Object value, String message) {
    if (value == null) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void requireNotNull(Object object) {
    requireNotNull(object, "Объект не может быть пустым");
  }

  public static void greaterThan(int value, int minValue, String message) {
    if (value < minValue) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void greaterThan(int value, int minValue) {
    greaterThan(value, minValue, "Значение должно быть больше " + minValue);
  }

  public static <T> void requireNotEmptyArray(T[] array) {
    Objects.requireNonNull(array);

    if (array.length == 0) {
      throw new IllegalArgumentException("Массив не может быть пустым");
    }
  }


  public static void requireNotEmptyCollection(Collection<?> collection) {
      requireNotEmptyCollection(collection, "Коллекция не может быть пустой");
  }

  public static void requireNotEmptyCollection(Collection<?> collection, String message) {
    Objects.requireNonNull(collection);

    if (collection.isEmpty()) {
      throw new IllegalArgumentException(message);
    }
  }

    public static void requirePathExists(Path path, String message) {
      if (!path.toFile().exists()) {
        throw new IllegalArgumentException(message);
      }
    }

  public static void requirePathEnds(Path path, String postfix, String message) {
    if (!path.toString().endsWith(postfix)) {
      throw new IllegalArgumentException(message);
    }
  }
}
