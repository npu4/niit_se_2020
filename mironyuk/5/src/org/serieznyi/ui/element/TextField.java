package org.serieznyi.ui.element;

import org.serieznyi.ui.Rectangle;

final public class TextField extends Rectangle {
    private String value;

    public TextField(int x, int y, int height, int width, String caption, String value) {
        super(x, y, height, width, caption);
        this.value = value;
    }

    @Override
    protected String getTypeName() {
        return "Текстовое поле";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
