package ui;

import elements.Button;
import elements.CheckMark;
import elements.Rectangle;
import elements.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UI {
    private static List<Rectangle> elements = new ArrayList<>();
    Random r = new Random();
    int cooX;
    int cooY;

    public static boolean elementCrossing(Rectangle r) throws RectangleCrossingException {
        boolean elementsNotCrossing = true;

        for (Rectangle iterator : elements) {
            if (iterator.getLeftCoornY() + iterator.getHeight() <= r.getLeftCoornY() ||
                    iterator.getLeftCoornY() >= r.getLeftCoornY() + r.getHeight() ||
                    iterator.getLeftCoornX() >= r.getLeftCoornX() + r.getLength() ||
                    iterator.getLeftCoornX() + iterator.getLength() <= r.getLeftCoornX()) ;
            else {
                System.out.printf(r.getName() + " пересекается с " + iterator.getName() + "\n");
                elementsNotCrossing = false;
                throw new RectangleCrossingException();
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
                Button newButton = new Button(x, y, "Кнопка", true);
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
        if (elementCrossing(r)) {
            elements.add(r);
        }
    }

    void newRandom() {
        cooX = r.nextInt(100);
        cooY = r.nextInt(100);
    }
}
