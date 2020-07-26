package org.serieznyi.ui;

import org.serieznyi.ui.exception.ElementsOverlapException;

import java.util.ArrayList;
import java.util.List;

public final class UI {
  private final int width;
  private final int height;
  List<Rectangle> elements = new ArrayList<>();

  UI(int width, int height) {

    this.width = width;
    this.height = height;
  }

  public List<Rectangle> getAllElements() {
    return elements;
  }

  public void addElement(Rectangle newRectangle) {
    for (Rectangle rectangle : elements) {
      if (newRectangle.isCross(rectangle)) {
        throw ElementsOverlapException.fromRectangles(newRectangle, rectangle);
      }
    }

    System.out.println("Добавил элемент: " + newRectangle);

    elements.add(newRectangle);
  }
}
