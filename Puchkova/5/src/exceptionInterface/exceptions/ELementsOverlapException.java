package exceptionInterface.exceptions;

public class ELementsOverlapException extends Exception{
    @Override
    public String getMessage() {
        return ("Пересечение с другими элементами. Невозможно добавить элемент.");
    }
}