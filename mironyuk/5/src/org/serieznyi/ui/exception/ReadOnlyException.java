package org.serieznyi.ui.exception;

import org.serieznyi.ui.Element;

public final class ReadOnlyException extends RuntimeException {
  private final Element element;

  public ReadOnlyException(Element element, String message) {
    super(message);

    this.element = element;
  }

  public static ReadOnlyException fromElement(final Element element) {
    String message = String.format("Элемент только для чтения: \"%s\"", element);

    return new ReadOnlyException(element, message);
  }

  public Element getElement() {
    return element;
  }
}
