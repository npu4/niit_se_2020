import java.util.Random;

public class CheckBox extends Rectangle implements Clickable {
    private boolean press;

    public  CheckBox(int x, int y){
        super(x, y, "Чек-бокс с координатами " + x + ":" + y);
        press = new Random().nextBoolean();
    }

    @Override
    public void click() {
        press = !press;
    }

    public boolean press() {
        return press;
    }

    @Override
    public String toString() {
        return "\nЧек-бокс в координатах" +
                " <" + this.getX() +
                ", " + this.getY() +
                ">, высота " + this.getHeight() +
                ", ширина " + this.getLength() +
                ", название '" + this.getCaption() +
                "'";
    }
}
