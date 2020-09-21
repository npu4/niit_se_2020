package BattleGame.Exceptions;

public class BattlersOutOfBounds extends Exception {
    @Override
    public String getMessage() {
        return ("Некорректное количество персонажей.");
    }
}
