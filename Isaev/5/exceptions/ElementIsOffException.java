package exceptions;

import elements.Rectangle;

public class ElementIsOffException extends Exception {
    public ElementIsOffException(Rectangle element) {
        super("Элемент выключен");
    }
}
