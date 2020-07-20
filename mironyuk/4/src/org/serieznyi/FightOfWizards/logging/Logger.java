package org.serieznyi.FightOfWizards.logging;

import org.serieznyi.FightOfWizards.character.Character;
import org.serieznyi.FightOfWizards.character.wizard.Spell;
import org.serieznyi.FightOfWizards.logging.handler.OutputHandler;

import java.util.Set;

import static java.lang.String.format;

final public class Logger {
    private static Logger instance;

    Handler handler = new OutputHandler();

    private Logger()
    {
    }

    public static Logger create() {

        if (null == instance) {
            instance = new Logger();
        }

        return instance;
    }

    public void setHandler(Handler handler)
    {
        this.handler = handler;
    }

    public void characterDead(Character character)
    {
        handler.dangerous(format("%s \"%s\" убит", character.getType(), character.getName()));
    }

    public void readSpell(Character character, Spell spell)
    {
        String message = format(
                "%s \"%s\" читает заклинание \"%s\"",
                character.getType(),
                character.getName(),
                spell.getName()
        );

        handler.info(message);
    }

    public void takeDamageTo(Character character, Spell spell, Set<Character> characters, int damage)
    {
        String message = format(
            "%s \"%s\" нанес урон \"%s\" с помощью заклинания \"%s\". Каждый получает \"%s\" единиц урона.",
            character.getType(),
            character.getName(),
            toNamesListAsString(characters),
            spell.getName(),
            damage
        );

        handler.warning(message);
    }

    public void takeDamageTo(Character character, Spell spell, Character opponent, int damage)
    {
        String message = format(
                "%s \"%s\" нанес урон персонажу \"%s\" в размере \"%s\" единиц с помощью заклинания \"%s\"",
                character.getType(),
                character.getName(),
                opponent.getName(),
                damage,
                spell.getName()
        );

        handler.warning(message);
    }

    public void takeDamageTo(Character character, Character opponent, int damage) {
    String message =
        format(
            "%s \"%s\" нанес \"%s\" единиц урона персонажу \"%s\"",
            character.getType(), character.getName(), damage, opponent.getName());

        handler.warning(message);
    }

    public void info(String s, Object ...args) {
        handler.info(format(s, args));
    }

    public void newline() {
        handler.info("");
    }

    public void characterAttack(Character aggressor, Character target) {
        String message = format(
            "%s \"%s\" атакует \"%s\"",
            aggressor.getType(),
            aggressor.getName(),
            target.getName()
        );

        handler.info(message);
    }

    public void debug(String s) {
        handler.debug(s);
    }

    private static String toNamesListAsString(Set<Character> characters) {
        return String.join(", ", characters.stream().map(Character::toString).toArray(String[]::new));
    }

    public void healing(Character character, int healingStrength, int newHealth)
    {
        String message = format(
                "%s \"%s\" исцелен на \"%s\". Теперь у него %s единиц здоровья",
                character.getType(),
                character.getName(),
                healingStrength,
                newHealth
        );

        handler.success(message);
    }

    public void spellWeaken(Spell spell, Character character) {
        String message = format(
                "Заклинание \"%s\" у мага \"%s\" ослабло",
                spell.getName(),
                character.getName()
        );

        handler.debug(message);
    }

    public void winner(Character winner) {
        handler.success(String.format("На поле боя остался только \"%s\"", winner.getName()));
    }
}
