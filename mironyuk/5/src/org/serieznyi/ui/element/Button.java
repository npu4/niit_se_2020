package org.serieznyi.ui.element;

import org.serieznyi.ui.Clickable;
import org.serieznyi.ui.exception.ReadOnlyException;

public final class Button extends Element implements Clickable {
  Runnable clickCallback;

  public Button(int x, int y, int height, int width, String caption, Runnable clickCallback) {
    super(x, y, height, width, caption);
    this.clickCallback = clickCallback;
  }

  @Override
  public void click() {
    if (!isEnabled()) {
      throw ReadOnlyException.fromElement(this);
    }

    clickCallback.run();
  }

  @Override
  protected String getTypeName() {
    return "Кнопка";
  }
}
