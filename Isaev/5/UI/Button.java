package UI;

import java.util.Random;

public class Button extends Elements implements Clickable{

    public Button(int coornX, int coornY, String caption) {
        super(coornX,coornY,caption);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public boolean isCurrentState() {
        return currentState;
    }

    public void setCurrentState(boolean currentState) {
        this.currentState = currentState;
    }

    @Override
    public void click() {

    }
}
