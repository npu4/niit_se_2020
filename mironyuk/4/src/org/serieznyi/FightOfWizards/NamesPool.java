package org.serieznyi.FightOfWizards;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

final class NamesPool {
    private static String[] ALLOWED_NAMES = {
            "Сатана",
            "Кракен",
            "Голод",
            "Голум",
            "Харрун",
            "Смерть",
            "Чума",
            "Ворон",
            "Крыса",
            "Зомби",
    };

    public String extractMonsterName()
    {
        ALLOWED_NAMES = Arrays.stream(ALLOWED_NAMES)
                .sorted((String s1, String s2) -> ThreadLocalRandom.current().nextInt(-1, 1))
                .toArray(String[]::new);

        if (0 == ALLOWED_NAMES.length) {
            throw new RuntimeException("Не осталось имен для монстров");
        }

        String selectedName = ALLOWED_NAMES[0];

        ALLOWED_NAMES = Arrays.copyOfRange(ALLOWED_NAMES, 1, ALLOWED_NAMES.length);

        return selectedName;
    }
}
