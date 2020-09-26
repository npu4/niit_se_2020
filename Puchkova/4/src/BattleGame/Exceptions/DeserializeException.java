package BattleGame.Exceptions;

public class DeserializeException extends Exception {
    @Override
    public String getMessage() {
        return ("Ошибка десериализации");
    }
}