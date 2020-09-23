package BattleGame.Exceptions;

public class UnknownCommand extends Exception {
    @Override
    public String getMessage() {
        return ("Неверная команда.");
    }
}
