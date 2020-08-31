package ui;

import elements.Button;
import elements.CheckMark;
import elements.Rectangle;
import elements.TextField;
import exceptions.RectangleCrossingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UI {
    private static List<Rectangle> elements = new ArrayList<>();
    Random r = new Random();
    int cooX;
    int cooY;

    public static boolean elementNotCrossing(Rectangle r) throws RectangleCrossingException {
        boolean elementsNotCrossing = true;

        for (Rectangle element : elements) {
            if (element.getLeftCoornY() + element.getHeight() <= r.getLeftCoornY() ||
                    element.getLeftCoornY() >= r.getLeftCoornY() + r.getHeight() ||
                    element.getLeftCoornX() >= r.getLeftCoornX() + r.getLength() ||
                    element.getLeftCoornX() + element.getLength() <= r.getLeftCoornX()) ;
            else {
                System.out.printf(r.getName() + " пересекается с " + element.getName() + "\n");
                elementsNotCrossing = false;
            }
        }
        return elementsNotCrossing;
    }

    public static List<Rectangle> getElements() {
        return elements;
    }

    public void addElement(int x, int y) throws RectangleCrossingException {
        int switchElement = new Random().nextInt(3);
        switch (switchElement) {
            case 0:
                Button newButton = new Button(x, y, String.format("Кнопка в <%d,%d>", x, y), true,
                        () -> System.out.println(String.format("Нажата кнопка в <%d,%d>", x, y)));
                this.addElement(newButton);
                break;
            case 1:
                CheckMark newCheckMark = new CheckMark(x, y, "Галка");
                this.addElement(newCheckMark);
                break;
            case 2:
                TextField newTextField = new TextField(x, y, "Текстовое поле", true);
                this.addElement(newTextField);
                break;
        }

    }

    public void addElement(Rectangle r) throws RectangleCrossingException {
        if (elementNotCrossing(r)) {
            elements.add(r);
        } else throw new RectangleCrossingException();
    }
}
