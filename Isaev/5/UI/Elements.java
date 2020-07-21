package UI;

import java.util.Random;

public class Elements{

    protected int coornX;
    protected int coornY;
    protected int width = new Random().nextInt();
    protected int high = new Random().nextInt();
    protected String caption;
    protected boolean currentState;

    public Elements() {
    }

    public Elements(int coornX, int coornY, String caption) {
        this.coornX = coornX;
        this.coornY = coornY;
        this.caption = caption;
    }
}
