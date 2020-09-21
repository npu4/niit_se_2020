package BattleGame.Exceptions;

public class TwoCharactersOnOnePlace extends Exception {
    @Override
    public String getMessage() {
        return ("Два персонажа претендовали на одно место.");
    }
}

