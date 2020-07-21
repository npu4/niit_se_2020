package UI;

public class CheckMark extends Elements implements Clickable{

    protected boolean markCurrentState;

    public CheckMark(int coornX, int coornY, String caption) {
        super(coornX, coornY, caption);

    }

    public boolean isMarkCurrentState() {
        return markCurrentState;
    }

    public void setMarkCurrentState(boolean markCurrentState) {
        this.markCurrentState = markCurrentState;
    }
}
