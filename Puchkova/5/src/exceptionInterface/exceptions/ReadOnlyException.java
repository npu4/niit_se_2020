package exceptionInterface.exceptions;

public class ReadOnlyException extends Exception{
    @Override
    public String getMessage() {
        return ("Элемент выключен.");
    }
}