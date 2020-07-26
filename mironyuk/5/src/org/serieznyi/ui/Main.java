package org.serieznyi.ui;

import org.serieznyi.ui.element.Button;
import org.serieznyi.ui.element.CheckBox;
import org.serieznyi.ui.element.TextField;
import org.serieznyi.ui.exception.ElementsOverlapException;
import org.serieznyi.ui.exception.ReadOnlyException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public final class Main {
  private static final int MAX_X_COORDINATE = 100;
  private static final int MAX_Y_COORDINATE = 100;

  public static void main(String[] args) {
    System.out.println("\nСоздаем UI c элементами управления:\n");

    UI ui = new UI(MAX_X_COORDINATE, MAX_Y_COORDINATE);

    TextField xCoordinateTextField =
        new TextField(0, 6, 5, 5, "Координата x для нового элемента", "");
    ui.addElement(xCoordinateTextField);

    TextField yCoordinateTextField =
        new TextField(0, 12, 5, 5, "Координата y для нового элемента", "");
    ui.addElement(yCoordinateTextField);

    Button addElementButton =
        new Button(
            0,
            0,
            5,
            5,
            "Добавить элемент",
            () -> {
              Rectangle randomElement =
                  makeRandomElement(
                      Integer.parseInt(xCoordinateTextField.getValue()),
                      Integer.parseInt(yCoordinateTextField.getValue()));
              ui.addElement(randomElement);
            });
    ui.addElement(addElementButton);

    System.out.println("\nГенерируем новые элементы:\n");

    for (int i = 0; i < 10; i++) {
      xCoordinateTextField.setValue(nextRandomXCoordinate().toString());
      yCoordinateTextField.setValue(nextRandomYCoordinate().toString());

      try {
        addElementButton.click();
      } catch (ElementsOverlapException e) {
        System.out.println("Ошибка: " + e.getMessage());
      }
    }

    System.out.println("\nВзаимодействуем с элементами интерфейса:\n");

    for (Rectangle rectangle : ui.getAllElements()) {
      System.out.println(rectangle);

      if (rectangle instanceof Clickable && rectangle != addElementButton) {
        try {
          ((Clickable) rectangle).click();
        } catch (ReadOnlyException e) {
          System.out.println("Ошибка: " + e.getMessage());
        }
      }

      if (rectangle instanceof CheckBox) {
        System.out.println("\tСостояние: " + ((CheckBox) rectangle).getState());
      }

      if (rectangle instanceof TextField) {
        System.out.println("\tТекст: " + ((TextField) rectangle).getValue());
      }

      System.out.println();
    }
  }

  private static Rectangle makeRandomElement(int x, int y) {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    int width = random.nextInt(1, MAX_X_COORDINATE / 3);
    int height = random.nextInt(1, MAX_Y_COORDINATE / 3);

    List<Supplier<Rectangle>> elementGenerator = new ArrayList<>();

    elementGenerator.add(
        () ->
            new Button(
                x,
                y,
                height,
                width,
                String.format("Кнопка в <%s,%s>", x, y),
                () -> System.out.println(String.format("Нажата кнопка в <%s, %s>", x, y))));

    elementGenerator.add(
        () ->
            new CheckBox(
                x, y, height, width, String.format("Галка в <%s,%s>", x, y), random.nextBoolean()));

    elementGenerator.add(
        () ->
            new TextField(
                x,
                y,
                height,
                width,
                "Текстовое поле в ",
                randomString().substring(0, random.nextInt(2, 10))));

    Rectangle newElement = elementGenerator.get(random.nextInt(0, elementGenerator.size())).get();

    if (random.nextBoolean()) {
      newElement.disable();
    }

    return newElement;
  }

  private static String randomString() {
    return Stream.generate(() -> ThreadLocalRandom.current().nextInt(48, 123))
        .limit(100)
        .map((a) -> (char) ((int) a))
        .collect(
            Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
  }

  private static Integer nextRandomXCoordinate() {
    return ThreadLocalRandom.current().nextInt(0, MAX_X_COORDINATE + 1);
  }

  private static Integer nextRandomYCoordinate() {
    return ThreadLocalRandom.current().nextInt(0, MAX_Y_COORDINATE + 1);
  }
}
