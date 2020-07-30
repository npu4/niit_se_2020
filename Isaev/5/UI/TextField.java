package UI;

public class TextField extends Elements{

    protected String inputText;

    public TextField(int coornX, int coornY, String caption, String inputText) {
        super(coornX, coornY, caption);
        this.inputText = inputText;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}
