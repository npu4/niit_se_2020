package interfaces;

import interfaces.elements.*;

public class Main {

    public static void main(String[] args) {
        UI scene = new UI();
        Button addElementsButton = new Button(0, 0, true);
        addElementsButton.setCaption("Кнопка 'Добавить элемент' в" +
                " <" + addElementsButton.getX() + "," + addElementsButton.getY() + ">");
        scene.getElements().add(addElementsButton);

        for (int i = 0; i < 3; i++) {
            addElementsButton.click();
        }

        System.out.println(scene.getElements() + "\n");

        for (int i = 1; i < scene.getElements().size(); i++) {
            Rectangle r = scene.getElements().get(i);
            if (r instanceof CheckBox) {
                ((Clickable) scene.getElements().get(i)).click();
                System.out.println(((CheckBox) r).isPressed());
            }
            if (r instanceof TextField) {
                System.out.println(((TextField) r).getText());
            }
            if (r instanceof Button) {
                ((Button) r).click();
            }
        }

    }
}
