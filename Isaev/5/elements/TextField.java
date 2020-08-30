package elements;

import java.util.Random;

public class TextField extends Rectangle {

    protected String inputText;
    protected int coordinate;

    public TextField(int x, int y, String name, boolean isTurnedON) {
        super(x, y, name, isTurnedON);
        this.coordinate = new Random().nextInt(100);
        this.setInputText(String.valueOf(new Random().nextLong()));
    }

    public int getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    public void refreshField() {
        this.setCoordinate(new Random().nextInt(100));
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}
