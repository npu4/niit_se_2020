package interfaces.exceptions;

public class ReadOnlyException extends Exception {
    public ReadOnlyException() {
        super("Элемент только для чтения!");
    }
}
