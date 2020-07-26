package org.serieznyi.ui.exception;

import org.serieznyi.ui.Rectangle;

final public class ElementsOverlapException extends RuntimeException {
    private final Rectangle a;
    private final Rectangle b;

    public static ElementsOverlapException fromRectangles(Rectangle a, Rectangle b)
    {
        return new ElementsOverlapException(String.format("Фигура \"%s\" пересекает фигуру \"%s\"", a, b), a, b);
    }

    public ElementsOverlapException(String message, Rectangle a, Rectangle b) {
        super(message);

        this.a = a;
        this.b = b;
    }

    public Rectangle getA() {
        return a;
    }

    public Rectangle getB() {
        return b;
    }
}
