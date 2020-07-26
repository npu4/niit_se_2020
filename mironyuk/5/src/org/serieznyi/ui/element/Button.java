package org.serieznyi.ui.element;

import org.serieznyi.ui.ButtonClickCallback;
import org.serieznyi.ui.Clickable;
import org.serieznyi.ui.Rectangle;
import org.serieznyi.ui.exception.ReadOnlyException;

final public class Button extends Rectangle implements Clickable {
    ButtonClickCallback callback;

    public Button(int x, int y, int height, int width, String caption, ButtonClickCallback callback) {
        super(x, y, height, width, caption);
        this.callback = callback;
    }

    @Override
    public void click() {
        if (!isEnabled()) {
            throw ReadOnlyException.fromElement(this);
        }

        callback.onButtonClick();
    }

    @Override
    protected String getTypeName() {
        return "Кнопка";
    }
}
