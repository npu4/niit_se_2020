package exceptionInterface.elements;

public class TextField extends Rectangle {
    String text;

    public TextField(int x, int y, int width, int height, String caption, boolean status, String text){
        super(x, y, width, height, caption, status);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
