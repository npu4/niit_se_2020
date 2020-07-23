package interfaces.exceptions;

public class ElementsOverlapException extends Exception {
    public ElementsOverlapException() {
        super("Элементы пересекаются");
    }
}
