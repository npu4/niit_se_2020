package org.serieznyi.ui.util;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Stream;

final public class Strings {
    public static String randomString()
    {
        return randomString(100);
    }

    public static String randomString(int length) {
        return Stream.generate(() -> ThreadLocalRandom.current().nextInt(48, 123))
                .limit(length)
                .map((a) -> (char) ((int) a))
                .collect(
                        Collector.of(
                                StringBuilder::new,
                                StringBuilder::append,
                                StringBuilder::append,
                                StringBuilder::toString));
    }
}
