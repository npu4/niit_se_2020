package com.lesson7;

import java.util.ArrayList;
import java.util.List;

public class UISample {


    static class BaseUIElement {
        int x;
        int y;

        public BaseUIElement(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    interface Clickable {
        void click();
    }


    static class Button extends BaseUIElement implements Clickable {


        String name;
        public Button(int x, int y, String name) {
            super(x, y);


        }

        @Override
        public void click() {
            System.out.println("Нажата кнопка в " + x + "," + y);
        }
    }
    static class CheckBox extends BaseUIElement implements Clickable {


        boolean isPressed;

        public CheckBox(int x, int y) {
            super(x, y);
        }

        @Override
        public void click() {
            isPressed = !isPressed;
            System.out.println(isPressed ? "Галочка отмечена" : "Галочка не отмечена");

        }
    }

    static class TextBox extends BaseUIElement  {
        String value;
        public TextBox(int x, int y) {
            super(x, y);
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


    public static <T extends BaseUIElement & Clickable> void  clickOnEveryElement(List<T> elements) {

        for (T element : elements) {
            System.out.println("Нажимаем элемент в " + element.x + " " + element.y);
            element.click();
        }
    }


    public static void main(String[] args) {
        List<CheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(new CheckBox(0, 0));
        checkBoxes.add(new CheckBox(10, 10));


        clickOnEveryElement(checkBoxes);

        List<BaseUIElement> someElements = new ArrayList<>();
     //   clickOnEveryElement(someElements);

     //   List<TextBox> textBox = new ArrayList<>();
    //    clickOnEveryElement(textBox);




    }

}

