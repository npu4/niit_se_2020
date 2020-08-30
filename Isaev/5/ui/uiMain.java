package ui;

import elements.Button;
import elements.CheckMark;
import elements.Rectangle;
import elements.TextField;

public class uiMain {

    public static void main(String[] args) throws RectangleCrossingException {
        UI ui = new UI();
        Button button = new Button(25, 25, "Добавить элемент", true);
        TextField cooX = new TextField(1, 1, "Координата x для нового элемента", true);
        TextField cooY = new TextField(1, 1, "Координата y для нового элемента", true);
        for (int i = 0; i < 10; i++) {
            try {
                ui.addElement(cooX.getCoordinate(), cooY.getCoordinate());
                cooX.refreshField();
                cooY.refreshField();
            } catch (RectangleCrossingException e) {
                e.printStackTrace();
            }
        }
        for (Rectangle element : ui.getElements()) {
            System.out.println(String.format("%s в координатах <%d,%d>, ширина <%d>, высота <%d>, название:<%s>",
                    element.getClass().getSimpleName(),
                    element.getLeftCoornX(),
                    element.getLeftCoornY(),
                    element.getLength(),
                    element.getHeight(),
                    element.getName()));
            if (element instanceof Button) {
                ((Button) element).click();
            }
            if (element instanceof CheckMark) {
                ((CheckMark) element).click();
                ((CheckMark) element).isMarkCurrentState();
            }
            if (element instanceof TextField) {
                ((TextField) element).getInputText();
            }
        }


    }

}
