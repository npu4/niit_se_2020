package org.serieznyi.ui;

import org.serieznyi.ui.element.Button;
import org.serieznyi.ui.element.CheckBox;
import org.serieznyi.ui.element.Element;
import org.serieznyi.ui.element.TextField;
import org.serieznyi.ui.util.Assert;
import org.serieznyi.ui.util.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class ElementFactory {
  private final int maxXCoordinate;
  private final int maxYCoordinate;
  private final ThreadLocalRandom random = ThreadLocalRandom.current();

  public ElementFactory(int maxXCoordinate, int maxYCoordinate) {

    Assert.greaterOrEqualsThan(maxXCoordinate, 0);
    Assert.greaterOrEqualsThan(maxYCoordinate, 0);

    this.maxXCoordinate = maxXCoordinate;
    this.maxYCoordinate = maxYCoordinate;
  }

  public Element createRandom(int x, int y) {
    List<Supplier<Element>> elementGenerator = new ArrayList<>();
    elementGenerator.add(createButton(x, y));
    elementGenerator.add(createCheckbox(x, y));
    elementGenerator.add(createTextField(x, y));

    int selectedElementType = random.nextInt(0, elementGenerator.size());

    Element newElement = elementGenerator.get(selectedElementType).get();

    if (random.nextBoolean()) {
      newElement.disable();
    }

    return newElement;
  }

  private int getRandomHeight() {
    return random.nextInt(1, maxYCoordinate / 3);
  }

  private int getRandomWidth() {
    return random.nextInt(1, maxXCoordinate / 3);
  }

  private Supplier<Element> createButton(int x, int y) {
    return () ->
        new Button(
            x,
            y,
            getRandomHeight(),
            getRandomWidth(),
            String.format("Кнопка в <%s,%s>", x, y),
            () -> System.out.println(String.format("Нажата кнопка в <%s, %s>", x, y)));
  }

  private Supplier<Element> createCheckbox(int x, int y) {
    return () ->
        new CheckBox(
            x,
            y,
            getRandomHeight(),
            getRandomWidth(),
            String.format("Галка в <%s,%s>", x, y),
            random.nextBoolean());
  }

  private Supplier<Element> createTextField(int x, int y) {
    return () ->
        new TextField(
            x,
            y,
            getRandomHeight(),
            getRandomWidth(),
            String.format("Текстовое поле в <%s>, %s", x, y),
            Strings.randomString(random.nextInt(2, 10)));
  }
}
