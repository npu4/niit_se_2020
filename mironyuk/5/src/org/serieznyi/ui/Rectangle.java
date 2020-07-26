package org.serieznyi.ui;

import org.serieznyi.ui.util.Assert;

public abstract class Rectangle {
  private final int x;
  private final int y;
  private final int height;
  private final int width;
  private final String caption;
  private boolean enabled = true;

  protected Rectangle(int x, int y, int height, int width, String caption) {
    Assert.zeroOrPositiveNumber(x);
    this.x = x;

    Assert.zeroOrPositiveNumber(y);
    this.y = y;

    Assert.positiveNumber(height);
    this.height = height;

    Assert.positiveNumber(width);
    this.width = width;

    Assert.requireNotEmptyString(caption);
    this.caption = caption;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public String getCaption() {
    return caption;
  }

  public void disable() {
    enabled = false;
  }

  public void enable() {
    enabled = true;
  }

  @Override
  public String toString() {
    return String.format(
        "%s в координатах [%s, %s], размер [h=%s, w=%s], название: \"%s\"",
        getTypeName(), x, y, height, width, caption);
  }

  protected abstract String getTypeName();

  /**
   * <p>Проверяем пересекается ли текущая фигура с rectangle
   *
   * <p>Прямоугольники НЕ пересекаются если:
   * <p>- верхний край второго лежит ниже нижнего края первого
   * <p>- или левый край первого лежит правее правого края второго
   * <p>- или левый край второго лежит правее правого края первого
   * <p>- или верхний край первого лежит ниже нижнего края второго
   *
   * @param rectangle фигура с которой проверяем пересечение
   * @return true если пересекается, иначе false
   */
  public boolean isCross(Rectangle rectangle) {
    return x <= rectangle.x + rectangle.width
        && rectangle.x <= x + width
        && y <= rectangle.y + rectangle.height
        && rectangle.y <= y + height;
  }
}
