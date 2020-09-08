package exceptionInterface.elements;

public class NothingOnClick implements ButtonClickCallback {
    Button linkedButton;

    NothingOnClick(Button b){
        linkedButton = b;

    }

    @Override
    public void onButtonClick() {
        System.out.println("Нажата кнопка в <" + linkedButton.getX() + ", " + linkedButton.getY() + ">");
    }
}