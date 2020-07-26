package org.serieznyi.ui.exception;

import org.serieznyi.ui.Rectangle;

public final class ElementsOverlapException extends RuntimeException {
  private final Rectangle a;
  private final Rectangle b;

  public ElementsOverlapException(String message, Rectangle a, Rectangle b) {
    super(message);

    this.a = a;
    this.b = b;
  }

  public static ElementsOverlapException fromRectangles(
      Rectangle newElement, Rectangle crossingWith) {
    String message =
        String.format(
            "Не могу добавить элемент \"%s\" т.к. он пересекает \"%s\"", newElement, crossingWith);

    return new ElementsOverlapException(message, newElement, crossingWith);
  }

  public Rectangle getA() {
    return a;
  }

  public Rectangle getB() {
    return b;
  }
}
