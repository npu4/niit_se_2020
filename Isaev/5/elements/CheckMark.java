package elements;

import exceptions.ElementIsOffException;
import interfaces.Clickable;

import java.util.Random;

public class CheckMark extends Rectangle implements Clickable {

    protected boolean markCurrentState;

    public CheckMark(int x, int y, String name) {
        super(x, y, name);
        super.setTurnedON(new Random().nextBoolean());
    }


    public boolean isMarkCurrentState() {
        return markCurrentState;
    }

    public void setMarkCurrentState(boolean markCurrentState) {
        this.markCurrentState = markCurrentState;
    }

    @Override
    public void click() throws ElementIsOffException {
        if (!isTurnedON()) {
            throw new ElementIsOffException(this);
        }
        markCurrentState = !markCurrentState;
    }
}
