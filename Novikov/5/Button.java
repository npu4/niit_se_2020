public class Button extends Rectangle implements Clickable {

    private boolean createElementButton;

    public Button(int x, int y, boolean createElementButton){
        super(x, y, "Кнопка c координатами "+ x +":"+y);
        this.createElementButton=createElementButton;
    }

    @Override
    public void click(){
        if( this.getX() >=0 && this.getY()>=0){
            System.out.printf(" Нажата кнопка с координатами " + this.getX()+":"+ this.getY()+"\n");
        }
        try {
            isElementActive(this.isOnOff());
            if (createElementButton) {
                UI.addElementRand();
            }
        }
        catch (DisableException q){
            System.err.println("Кнопка выключена." + this);
        }
        catch (CrossException q){
            System.err.println("Элементы имеют пересечение.");
        }
    }

    public void click(int x, int y){
        if( this.getX() >=0 && this.getY()>=0){
            System.out.printf("Нажата кнопка с координатами " + this.getX()+":"+ this.getY()+"\n");
        }
        try {
            isElementActive(this.isOnOff());
            if (createElementButton) {
                UI.addElementForEnteredCoordinates(x,y);
            }
        }
        catch (DisableException q){
            System.err.println("Элемент выключен.");
        }
        catch (CrossException q){
            System.err.println("Элементы имеют пересечение.");
        }
    }

    @Override
    public String toString() {
        return "\nКнопка в координатах" +
                " <" + this.getX() +
                ", " + this.getY() +
                ">, высота " + this.getHeight()+
                ", ширина " + this.getLength() +
                ", название '" + this.getCaption() +
                "'";
    }

}
