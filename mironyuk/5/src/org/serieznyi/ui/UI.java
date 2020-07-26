package org.serieznyi.ui;

import org.serieznyi.ui.element.Element;
import org.serieznyi.ui.exception.ElementsOverlapException;

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
    for (Element element : elements) {
      if (newElement.isCross(element)) {
        throw ElementsOverlapException.fromRectangles(newElement, element);
      }
    }

    System.out.println("Добавил элемент: " + newElement);

    elements.add(newElement);
  }
}
