package interfaces.elements;

import interfaces.exceptions.ElementsOverlapException;
import interfaces.exceptions.ReadOnlyException;
import interfaces.UI;

public class Button extends Rectangle implements Clickable {
    private boolean isButtonCreateElements;

    public Button(int x, int y, boolean isButtonCreateElements) {
        super(x, y, "Кнопка в <" + x + "," + y + ">");
        this.isButtonCreateElements = isButtonCreateElements;
    }

    @Override
    public void click() {
        if (this.x != 0 && this.y != 0) {
            System.out.printf("Нажата кнопка в <%d,%d>\n", x, y);
        }
        try {
            isElementActive(isOn);
            if (isButtonCreateElements) {
                UI.addElement();
            }
        } catch (ReadOnlyException e) {
            System.err.println("Элемент только для чтения!");
        } catch (ElementsOverlapException e) {
            System.err.println("Элементы пересекаются!");
        }
    }

    @Override
    public String toString() {
        return "\nКнопка в координатах" +
                " <" + x +
                ", " + y +
                ">, высота " + height +
                ", ширина " + length +
                ", название '" + caption +
                "'";
    }
}
