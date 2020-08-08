package org.serieznyi.serialization.serializer;

import java.util.Objects;

public final class Assert {
    private Assert() {}

    public static void requireNotEmptyString(String value) {
        requireNotEmptyString(value, "Строка не может быть пустой");
    }

    public static void requireNotEmptyString(String value, String message) {
        Objects.requireNonNull(value);

        if (value.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
