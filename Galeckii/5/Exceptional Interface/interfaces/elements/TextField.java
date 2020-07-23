package interfaces.elements;

import java.util.Random;

public class TextField extends Rectangle {
    private final String text;

    public TextField(int x, int y) {
        super(x, y, "Текстовое поле в <" + x + "," + y + ">");
        text = createText();
    }

    public String createText() {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        int length = random.nextInt(10) + 1;
        for (int i = 0; i < length; i++) {
            char ch = (char) ('a' + random.nextInt(26));
            text.append(ch);
        }
        return text.toString();
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "\nТекстовое поле в координатах" +
                " <" + x +
                ", " + y +
                ">, высота " + height +
                ", ширина " + length +
                ", название '" + caption +
                "'";
    }
}
