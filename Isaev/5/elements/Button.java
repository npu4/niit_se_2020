package elements;

import exceptions.ElementIsOffException;
import interfaces.Clickable;

public class Button extends Rectangle implements Clickable {
    Runnable clickCallback;


    public Button(int x, int y, String name, boolean isTurnedON, Runnable clickCallback) {
        super(x, y, name, isTurnedON);
        this.clickCallback = clickCallback;
    }

    @Override
    public void click() throws ElementIsOffException {
        if (!isTurnedON()) {
            throw new ElementIsOffException(this);
        }
        clickCallback.run();
    }
}

