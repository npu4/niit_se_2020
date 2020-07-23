package interfaces;

import interfaces.elements.Button;
import interfaces.elements.CheckBox;
import interfaces.elements.Rectangle;
import interfaces.elements.TextField;
import interfaces.exceptions.ElementsOverlapException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UI {
    private static List<Rectangle> elements = new ArrayList<>();
    private static final int HEIGHT = 30;
    private static final int LENGTH = 30;
    private static Random random = new Random();
    public static int randomX;
    public static int randomY;

    public static void addElement(Rectangle element) throws ElementsOverlapException {
        if (!isRectanglesOverlap(element)) {
            elements.add(element);
        }
    }

    public static void addElement() throws ElementsOverlapException {
        refreshXY();
        switch (random.nextInt(3)) {
            case (0):
                Button button = new Button(randomX, randomY, false);
                addElement(button);
                break;
            case (1):
                CheckBox checkBox = new CheckBox(randomX, randomY);
                addElement(checkBox);
                break;
            case (2):
                TextField textField = new TextField(randomX, randomY);
                addElement(textField);
                break;
        }
    }

    public static boolean isRectanglesOverlap(Rectangle element) throws ElementsOverlapException {
        int[] elementCoos = new int[]{element.getX(), element.getY(),
                element.getX() + element.getLength(), element.getY() + element.getHeight()};
        boolean isOverlap=true;

        for (Rectangle rectangle : elements) {
            int[] rectangleCoos = new int[]{rectangle.getX(), rectangle.getY(),
                    rectangle.getX() + rectangle.getLength(), rectangle.getY() + rectangle.getHeight()};

            isOverlap = !(elementCoos[2] <= rectangleCoos[0] ||   // left
                    elementCoos[3] <= rectangleCoos[1] ||   // bottom
                    elementCoos[0] >= rectangleCoos[2] ||   // right
                    elementCoos[1] >= rectangleCoos[3]);    // top

            if (isOverlap) {
                System.out.printf("%s пересекается с %s\n", element.getCaption(), rectangle.getCaption());
                throw new ElementsOverlapException();
            }
        }
        return isOverlap;
    }

    public static void refreshXY() {
        randomX = random.nextInt(LENGTH);
        randomY = random.nextInt(HEIGHT);
        System.out.printf("Координаты %d и %d для нового элемента\n", randomX, randomY);
    }

    public List<Rectangle> getElements() {
        return elements;
    }

}
