package org.serieznyi.ui;

import org.serieznyi.ui.element.Element;
import org.serieznyi.ui.exception.ElementOversizeException;
import org.serieznyi.ui.exception.ElementOverlapException;

import java.util.ArrayList;
import java.util.List;

public final class UI {
  private final int width;
  private final int height;
  List<Element> elements = new ArrayList<>();

  UI(int width, int height) {

    this.width = width;
    this.height = height;
  }

  public List<Element> getAllElements() {
    return elements;
  }

  public void addElement(Element newElement) {
    if (isTooBig(newElement)) {
      throw ElementOversizeException.fromElement(newElement);
    }

    for (Element element : elements) {
      if (newElement.isCross(element)) {
        throw ElementOverlapException.fromElements(newElement, element);
      }
    }

    System.out.println("Добавил элемент: " + newElement);

    elements.add(newElement);
  }

  private boolean isTooBig(Element newElement) {
    return newElement.getX() + newElement.getWidth() > width ||
            newElement.getY() + newElement.getHeight() > height;
  }
}
