package org.serieznyi.FightOfWizards;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

final class NamesPool {
    private static String[] ALLOWED_MONSTER_NAMES = {
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

    private static String[] ALLOWED_WIZARD_NAMES = {

    };

    public String extractMonsterName()
    {
        ALLOWED_MONSTER_NAMES = Arrays.stream(ALLOWED_MONSTER_NAMES)
                .sorted((String s1, String s2) -> ThreadLocalRandom.current().nextInt(-1, 1))
                .toArray(String[]::new);

        if (0 == ALLOWED_MONSTER_NAMES.length) {
            throw new RuntimeException("Не осталось имен для монстров");
        }

        String selectedName = ALLOWED_MONSTER_NAMES[0];

        ALLOWED_MONSTER_NAMES = Arrays.copyOfRange(ALLOWED_MONSTER_NAMES, 1, ALLOWED_MONSTER_NAMES.length);

        return selectedName;
    }

    public String extractWizardsName()
    {
        ALLOWED_MONSTER_NAMES = Arrays.stream(ALLOWED_WIZARD_NAMES)
                .sorted((String s1, String s2) -> ThreadLocalRandom.current().nextInt(-1, 1))
                .toArray(String[]::new);

        if (0 == ALLOWED_MONSTER_NAMES.length) {
            throw new RuntimeException("Не осталось имен для магов");
        }

        String selectedName = ALLOWED_MONSTER_NAMES[0];

        ALLOWED_MONSTER_NAMES = Arrays.copyOfRange(ALLOWED_MONSTER_NAMES, 1, ALLOWED_MONSTER_NAMES.length);

        return selectedName;
    }
}
