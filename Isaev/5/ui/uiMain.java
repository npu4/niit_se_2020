package ui;

import elements.Button;
import elements.CheckMark;
import elements.Rectangle;
import elements.TextField;
import exceptions.ElementIsOffException;
import exceptions.RectangleCrossingException;

public class uiMain {

    public static void main(String[] args) throws RectangleCrossingException, ElementIsOffException {
        UI ui = new UI();
        TextField cooX = new TextField(1, 1, "Координата x для нового элемента", true);
        TextField cooY = new TextField(1, 1, "Координата y для нового элемента", true);
        Button button = new Button(25, 25, "Добавить элемент", true,
                () ->
                {
                    try {
                        ui.addElement(cooX.getCoordinate(), cooY.getCoordinate());
                    } catch (RectangleCrossingException e) {
                        e.printStackTrace();
                    }
                    cooX.refreshField();
                    cooY.refreshField();
                });
        for (int i = 0; i < 10; i++) {
            button.click();
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
                try {
                    ((Button) element).click();
                } catch (ElementIsOffException e) {
                    e.printStackTrace();
                }
            }
            if (element instanceof CheckMark) {
                try {
                    ((CheckMark) element).click();
                    ((CheckMark) element).isMarkCurrentState();
                } catch (ElementIsOffException e) {
                    e.printStackTrace();
                }

            }
            if (element instanceof TextField) {
                ((TextField) element).getInputText();
            }
        }
    }


    }
