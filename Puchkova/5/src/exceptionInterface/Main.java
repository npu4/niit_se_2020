package exceptionInterface;

import exceptionInterface.elements.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int NUM_OF_TRYINGS = 10;
        UI ui = new UI(new Rectangle[0]);

        String xCoordinate;
        String yCoordinate;
        int xC = new Random().nextInt(UI.WIDTH);
        int yC = new Random().nextInt(UI.HEIGHT);
        xCoordinate = Integer.toString(xC);
        yCoordinate = Integer.toString(yC);

        Button b = new Button(1,1,4,2, "Добавить элемент", true);
        b.setCallback(new AddElementOnClick(ui, xC, yC));
        Rectangle t1 = new TextField(20,15,14,2, "Координата x для нового элемента", true, xCoordinate);
        Rectangle t2 = new TextField(20,20,14,2, "Координата y для нового элемента", true, yCoordinate);

        ui.addElement(b);
        ui.addElement(t1);
        ui.addElement(t2);

        b.click();

        for(int i = 0; i < NUM_OF_TRYINGS; i++){
            xC = new Random().nextInt(UI.WIDTH);
            yC = new Random().nextInt(UI.HEIGHT);

            b = new Button(1,1,4,2, "Добавить элемент", true);
            b.setCallback(new AddElementOnClick(ui, xC, yC));

            b.click();
        }

        System.out.println("\n Список элементов \n");

        ui.getAllElements();
    }
}
