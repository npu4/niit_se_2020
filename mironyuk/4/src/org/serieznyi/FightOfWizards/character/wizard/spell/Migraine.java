package org.serieznyi.FightOfWizards.character.wizard.spell;

import org.serieznyi.FightOfWizards.Scene;
import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.Wizard;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final public class Migraine implements Spell {
    /**
     * Количество урона наносимое заклинанием
     */
    private final int damage;

    public Migraine(int damage) {

        Assert.greaterThan(damage, 1);
        this.damage = damage;
    }

    @Override
    public String getName() {
        return "Мигрень";
    }

    @Override
    public String getDescription() {
        return "Наносит урон всем магам";
    }

    @Override
    public void cast(Character wizard, Scene scene) {

        List<String> damagedOpponentNames = new ArrayList<>();

        Map<Integer, Character> opponents = scene.getOpponentsFor(wizard);

        for (Map.Entry<Integer, Character> entry: opponents.entrySet()) {
            Character opponent = entry.getValue();

            if (opponent instanceof Wizard) {
                opponent.decreaseHealth(damage);
                damagedOpponentNames.add(opponent.getName());
            }
        }

        String opponentNames = String.join(", ", damagedOpponentNames);

        System.out.printf("\t%s наносит урон монстрам \"%s\". Каждый получает \"%s\" единиц урона.\n", getName(), opponentNames, damage);
    }
}
