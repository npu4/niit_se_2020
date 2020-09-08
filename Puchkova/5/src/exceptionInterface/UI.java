package exceptionInterface;

import exceptionInterface.elements.Button;
import exceptionInterface.elements.CheckBox;
import exceptionInterface.elements.Rectangle;
import exceptionInterface.elements.TextField;
import exceptionInterface.exceptions.ELementsOverlapException;

public class UI {
    static final int WIDTH = 100;
    static final int HEIGHT = 100;
    private Rectangle[] element;

    UI(Rectangle[] element){
        this.element = element;
    }

    void getAllElements(){
        for(int i = 0; i < element.length; i++){
            if(element[i] instanceof Button){
                System.out.println("Кнопка в координатах <" + element[i].getX() + ", " + element[i].getY() +
                        ">, ширина " + element[i].getWidth() + ", высота "+ element[i].getHeight() +
                        ", Название: " + element[i].getCaption());
                if(i > 0){
                    ((Button) element[i]).click();
                }
            }
            if(element[i] instanceof CheckBox){
                System.out.println("Галка в координатах <" + element[i].getX() + ", " + element[i].getY() +
                        ">, ширина " + element[i].getWidth() + ", высота "+ element[i].getHeight() +
                        ", Название: " + element[i].getCaption());
                ((CheckBox) element[i]).click();
                    System.out.println(element[i].getStatus());
            }
            if(element[i] instanceof TextField){
                System.out.println("Текст в координатах <" + element[i].getX() + ", " + element[i].getY() +
                        ">, ширина " + element[i].getWidth() + ", высота "+ element[i].getHeight() +
                        ", Название: " + element[i].getCaption());
                System.out.println(((TextField) element[i]).getText());
            }
        }
    }

    public void addElement(Rectangle el) {
        Rectangle k = new Rectangle(0,0,0,0,"",false);
        try {
            if (element != null){
                for(Rectangle i : element){
                    if(isRectanglesIntersect(el, i)){
                        k = i;
                        throw new ELementsOverlapException();
                    }
                }
                Rectangle[] newElements = new Rectangle[element.length + 1];
                System.arraycopy(element, 0, newElements, 0, element.length);
                newElements[element.length] = el;
                element = newElements;
            }
            else {
                Rectangle[] newElements = new Rectangle[1];
                newElements[0] = el;
                element = newElements;
            }
        }
        catch (ELementsOverlapException e){
            System.out.println(e.getMessage());
            System.out.println("Элемент в координатах <" + el.getX() + ", " + el.getY() +
                    ">, ширина " + el.getWidth() + ", высота "+ el.getHeight() +
                    ", Название: " + el.getCaption() + " пересекается с элементом в координатах <" + k.getX() + ", " + k.getY() +
                    ">, ширина " + k.getWidth() + ", высота "+ k.getHeight() +
                    ", Название: " + k.getCaption());
        }
    }

    boolean isPointInRectangle(int x, int y, Rectangle rectangle){
        return (rectangle.getX() <= x & x <= rectangle.getX() + rectangle.getWidth()) && (rectangle.getY() <= y & y <= rectangle.getY() + rectangle.getHeight());
    }

    boolean isRectanglesIntersect(Rectangle r1, Rectangle r2){
        return isPointInRectangle(r1.getX(), r1.getY(), r2) ||
                isPointInRectangle(r1.getX() + r1.getWidth(), r1.getY(), r2) ||
                isPointInRectangle(r1.getX(), r1.getY() + r1.getHeight(), r2) ||
                isPointInRectangle(r1.getX() + r1.getWidth(), r1.getY() + r1.getHeight(), r2);
    }
}