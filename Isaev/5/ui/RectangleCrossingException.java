package ui;

public class RectangleCrossingException extends Exception {
    public RectangleCrossingException() {
        super("Обнаружено пересечение элементов");
    }
}
