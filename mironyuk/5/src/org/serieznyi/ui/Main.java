package org.serieznyi.ui;

import org.serieznyi.ui.element.Button;
import org.serieznyi.ui.element.CheckBox;
import org.serieznyi.ui.element.Element;
import org.serieznyi.ui.element.TextField;
import org.serieznyi.ui.exception.ElementOverlapException;
import org.serieznyi.ui.exception.ElementOversizeException;
import org.serieznyi.ui.exception.ReadOnlyException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public final class Main {
  private static final int MAX_X_COORDINATE = 100;
  private static final int MAX_Y_COORDINATE = 100;

  public static void main(String[] args) {
    ElementFactory elementFactory = new ElementFactory(MAX_X_COORDINATE, MAX_Y_COORDINATE);

    System.out.println("\nСоздаем UI c элементами управления:\n");

    Stage stage = new Stage(MAX_X_COORDINATE, MAX_Y_COORDINATE);

    TextField xCoordinateTextField =
        new TextField(0, 6, 5, 5, "Координата x для нового элемента", "");
    stage.addElement(xCoordinateTextField);

    TextField yCoordinateTextField =
        new TextField(0, 12, 5, 5, "Координата y для нового элемента", "");
    stage.addElement(yCoordinateTextField);

    Button addElementButton =
        new Button(
            0,
            0,
            5,
            5,
            "Добавить элемент",
            () -> {
              int x = Integer.parseInt(xCoordinateTextField.getValue());
              int y = Integer.parseInt(yCoordinateTextField.getValue());
              stage.addElement(elementFactory.createRandom(x, y));
            });
    stage.addElement(addElementButton);

    System.out.println("\nГенерируем новые элементы:\n");

    for (int i = 0; i < 10; i++) {
      xCoordinateTextField.setValue(nextRandomXCoordinate().toString());
      yCoordinateTextField.setValue(nextRandomYCoordinate().toString());

      try {
        addElementButton.click();
      } catch (ElementOverlapException|ElementOversizeException e) {
        System.out.println("Ошибка: " + e.getMessage());
      }
    }

    List<Element> elements = stage.getAllElements();

    System.out.println(format("\nВзаимодействуем с элементами интерфейса. Элементов на сцене: %s:\n", elements.size()));

    for (Element element : elements) {
      System.out.println(element);

      if (element instanceof CheckBox) {
        System.out.println("\tСостояние: " + ((CheckBox) element).getState());
      } else if (element instanceof TextField) {
        System.out.println("\tТекст: " + ((TextField) element).getValue());
      } else if (element instanceof Clickable && element != addElementButton) {
        try {
          ((Clickable) element).click();
        } catch (ReadOnlyException e) {
          System.out.println("Ошибка: " + e.getMessage());
        }
      }

      System.out.println();
    }
  }

  private static Integer nextRandomXCoordinate() {
    return ThreadLocalRandom.current().nextInt(0, MAX_X_COORDINATE);
  }

  private static Integer nextRandomYCoordinate() {
    return ThreadLocalRandom.current().nextInt(0, MAX_Y_COORDINATE);
  }
}
