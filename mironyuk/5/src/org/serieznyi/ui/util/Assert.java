package org.serieznyi.ui.util;

import java.util.Objects;

import static java.lang.String.format;

public final class Assert {
  private Assert() {}

  public static void requireNotEmpty(String str) {
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
      String message = format("Значение \"%s\" должно быть больше \"%s\"", value, minValue);

      throw new IllegalArgumentException(message);
    }
  }

  /**
   * Число должно быть больше или равно init
   *
   * @param value значение для проверки
   * @param min значение для сравнения
   */
  public static void greaterOrEqualsThan(int value, int min) {
    if (value < min) {
      String message = format("Число \"%s\" должно быть больше или равно \"%s\"", value, min);

      throw new IllegalArgumentException(message);
    }
  }
}
