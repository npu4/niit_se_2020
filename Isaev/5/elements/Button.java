package elements;

import interfaces.Clickable;

public class Button extends Rectangle implements Clickable {

    public Button(int x, int y, String name, boolean isTurnedON) {
        super(x, y, name, isTurnedON);
    }

    @Override
    public void click() {
        System.out.println(String.format("Вы нажали кнопку в <%d,%d>", this.getLeftCoornX(), this.getLeftCoornY()));
    }
}
