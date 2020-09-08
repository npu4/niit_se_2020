package exceptionInterface.elements;

import exceptionInterface.UI;

import java.util.Random;

public class AddElementOnClick implements ButtonClickCallback {
    private static final int NUM_OF_ELEMENT_TYPES = 3;
    private static final int TEXT_LENGTH = 10;
    private final int xButton;
    private final int yButton;
    UI scene;


    public AddElementOnClick(UI sceneToAddElements, int xButton, int yButton) {
        this.xButton = xButton;
        this.yButton = yButton;
        scene = sceneToAddElements;
    }

    @Override
    public void onButtonClick(){
        Rectangle toAdd = generateRandomElement();
        scene.addElement(toAdd);
    }

    public Rectangle generateRandomElement(){
        int k = new Random().nextInt(NUM_OF_ELEMENT_TYPES);
        switch (k){
            case 0: Button b = new Button(xButton,yButton,new Random().nextInt(30) + 1,new Random().nextInt(30) + 1,
                    "Кнопка в <" + xButton+ ", " + yButton + ">", true);
                    b.setCallback(new NothingOnClick(b));
                    return b;
            case 1: return new CheckBox(xButton,yButton,new Random().nextInt(30) + 1,new Random().nextInt(30) + 1,
                    "Галка в <" + xButton+ ", " + yButton + ">", new Random().nextBoolean(), new Random().nextBoolean());
            default:
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < TEXT_LENGTH; i++){
                    str.append((char) (new Random().nextInt(128 - 32) + 32));
                }
                return new TextField(xButton,yButton,new Random().nextInt(30) + 1,new Random().nextInt(30) + 1,
                    "Текст в <" + xButton+ ", " + yButton + ">", true, str.toString());
        }
    }
}