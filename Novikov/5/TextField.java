
import java.util.Random;

public class TextField extends Rectangle {
    private static Random random = new Random();
    private String text;

    public TextField(int x, int y, String name, String text){
        super(x, y, name);
        this.text= text;
    }

    public TextField(int x, int y, String name){
        super(x, y, name);
    }

    public void newText(String text){
        this.text=text;
    }

    public void newTextConvertIntToString(int perem){
        this.text=String.valueOf (perem);
    }

    public String getText(){
        return text;
    }

    @Override
    public String toString() {
        return "\nТекстовое поле в координатах" +
                " <" + this.getX() +
                ", " + this.getY() +
                ">, высота " + this.getHeight() +
                ", ширина " + this.getLength() +
                ", название '" + this.getCaption() +
                "'";
    }
}
