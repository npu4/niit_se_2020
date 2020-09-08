package exceptionInterface.elements;

import exceptionInterface.exceptions.ReadOnlyException;

public class CheckBox extends Rectangle implements Clickable {
    private boolean checked;

    CheckBox(int x, int y, int width, int height, String caption, boolean status, boolean checked){
        super(x, y, width, height, caption, status);
        this.checked = checked;
    }

    @Override
    public void click() {
        try {
            if(!getStatus()){
                throw new ReadOnlyException();
            }
            checked = !checked;
        }
        catch(ReadOnlyException e){
            System.out.println(e.getMessage());
        }
    }
}
