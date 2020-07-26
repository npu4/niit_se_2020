package org.serieznyi.ui.exception;

import org.serieznyi.ui.Rectangle;

final public class ReadOnlyException extends RuntimeException {
    private final Rectangle rectangle;

    public ReadOnlyException(Rectangle rectangle, String message) {
        super(message);

        this.rectangle = rectangle;
    }

    public static ReadOnlyException fromElement(final Rectangle rectangle)
    {
        String message = String.format("Элемент только для чтения: \"%s\"", rectangle);

        return new ReadOnlyException(
                rectangle,
                message
        );
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
