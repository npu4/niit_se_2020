package org.serieznyi.ui.element;

import org.serieznyi.ui.Clickable;
import org.serieznyi.ui.Rectangle;
import org.serieznyi.ui.exception.ReadOnlyException;

final public class CheckBox extends Rectangle implements Clickable {
    private boolean state = false;

    public CheckBox(int x, int y, int height, int width, String caption) {
        super(x, y, height, width, caption);
    }

    public CheckBox(int x, int y, int height, int width, String caption, boolean state) {
        super(x, y, height, width, caption);

        this.state = state;
    }

    @Override
    protected String getTypeName() {
        return "Галка";
    }

    @Override
    public void click() {
        if (!isEnabled()) {
            throw ReadOnlyException.fromElement(this);
        }

        state = !state;
    }

    public boolean getState() {
        return state;
    }
}
