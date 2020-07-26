package org.serieznyi.ui.util;

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

  public static void requireNotNull(Object str) {
    Objects.requireNonNull(str);
  }

  public static void greaterThan(int value, int minValue) {
    if (value < minValue) {
      throw new IllegalArgumentException("Значение должно быть больше " + minValue);
    }
  }

  public static <T> void requireNotEmptyArray(T[] array) {
    Objects.requireNonNull(array);

    if (array.length == 0) {
      throw new IllegalArgumentException("Массив не может быть пустым");
    }
  }

  public static void requireNotEmptyCollection(Collection<?> collection) {
    Objects.requireNonNull(collection);

    if (collection.isEmpty()) {
      throw new IllegalArgumentException("Коллекция не может быть пустой");
    }
  }

  public static void zeroOrPositiveNumber(int number) {
    if (number < 0) {
      throw new IllegalArgumentException("Число должно быть положительным или нулем");
    }
  }

  public static void positiveNumber(int number) {
    if (number <= 0) {
      throw new IllegalArgumentException("Число должно быть положительным");
    }
  }
}
