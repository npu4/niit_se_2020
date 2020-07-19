package org.serieznyi.FightOfWizards.util;

import java.util.concurrent.ThreadLocalRandom;

final public class Functions {
    private Functions() {}

    public static <T> int randomComparator(T s1, T s2)
    {
        return ThreadLocalRandom.current().nextInt(-1, 2);
    }
}
