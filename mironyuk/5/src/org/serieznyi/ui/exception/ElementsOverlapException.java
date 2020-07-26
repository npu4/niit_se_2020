package org.serieznyi.ui.exception;

import org.serieznyi.ui.element.Element;

public final class ElementsOverlapException extends RuntimeException {
  private final Element a;
  private final Element b;

  public ElementsOverlapException(String message, Element a, Element b) {
    super(message);

    this.a = a;
    this.b = b;
  }

  public static ElementsOverlapException fromRectangles(
          Element newElement, Element crossingWith) {
    String message =
        String.format(
            "Не могу добавить элемент \"%s\" т.к. он пересекает \"%s\"", newElement, crossingWith);

    return new ElementsOverlapException(message, newElement, crossingWith);
  }

  public Element getA() {
    return a;
  }

  public Element getB() {
    return b;
  }
}
