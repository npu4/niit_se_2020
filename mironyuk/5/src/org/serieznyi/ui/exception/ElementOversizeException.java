package org.serieznyi.ui.exception;

import org.serieznyi.ui.element.Element;

public final class ElementOversizeException extends RuntimeException {
  private final Element element;

  private ElementOversizeException(String message, Element element) {
    super(message);

    this.element = element;
  }

  public static ElementOversizeException fromElement(Element newElement) {
    String message = String.format("Элемент \"%s\" не помещается на сцене", newElement);

    return new ElementOversizeException(message, newElement);
  }

  public Element getElement() {
    return element;
  }
}
