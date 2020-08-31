package exceptions;

public class RectangleCrossingException extends Exception {
    public RectangleCrossingException() {
        super("Обнаружено пересечение элементов");
    }
}
