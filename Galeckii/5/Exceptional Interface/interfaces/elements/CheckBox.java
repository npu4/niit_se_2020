package interfaces.elements;

import java.util.Random;

public class CheckBox extends Rectangle implements Clickable {
    private boolean isPressed;

    public CheckBox(int x, int y) {
        super(x, y, "Чек-бокс в <" + x + "," + y + ">");
        isPressed = new Random().nextBoolean();
    }

    @Override
    public void click() {
        isPressed = !isPressed;
    }

    public boolean isPressed() {
        return isPressed;
    }

    @Override
    public String toString() {
        return "\nЧек-бокс в координатах" +
                " <" + x +
                ", " + y +
                ">, высота " + height +
                ", ширина " + length +
                ", название '" + caption +
                "'";
    }
}
