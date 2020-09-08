package exceptionInterface.elements;

import exceptionInterface.exceptions.ELementsOverlapException;
import exceptionInterface.exceptions.ReadOnlyException;

public class Button extends Rectangle implements Clickable {
    ButtonClickCallback callback;

    public Button(int x, int y, int width, int height, String caption, boolean status) {
        super(x, y, width, height, caption, status);
    }

    public void setCallback(ButtonClickCallback callback) {
        this.callback = callback;
    }

    @Override
    public void click(){
        try {
            if(!getStatus()){
                throw new ReadOnlyException();
            }
            callback.onButtonClick();
        }
        catch(ReadOnlyException | ELementsOverlapException e){
            System.out.println(e.getMessage());
        }
    }
}
