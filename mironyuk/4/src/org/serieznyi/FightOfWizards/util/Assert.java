package org.serieznyi.FightOfWizards.util;

import java.util.Objects;

final public class Assert {
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
}
