import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UI {
    private static List<Rectangle> field=new ArrayList<>();
    private static Random random = new Random();
    public static int randX;
    public static int randY;


    public static void addElem(Rectangle elem) throws  CrossException {
        if(crossElem(elem))
        field.add(elem);
    }

    public static boolean crossElem(Rectangle elem) throws CrossException{
        boolean notElemCross=true;

        for(Rectangle iteratior: field ){
            if(iteratior.getX()+iteratior.getLength()<=elem.getX()|| //Нет пересечений
                    iteratior.getY()+iteratior.getHeight()<=elem.getY()||
                    iteratior.getX()>=elem.getX()+elem.getLength()||
                    iteratior.getY()>=elem.getY()+elem.getHeight());
            else {
                System.out.printf(elem.getCaption()+" пересекается с "+ iteratior.getCaption() +"\n");
                notElemCross=false;
                throw new CrossException();
            }
        }
        return notElemCross;
    }


    public static void addElementRand() throws CrossException {
        randXY();
        switch (random.nextInt(3)) {
            case (0):
                Button button = new Button(randX, randY, false);
                addElem(button);
                break;
            case (1):
                CheckBox checkBox = new CheckBox(randX, randY);
                addElem(checkBox);
                break;
            case (2):
                TextField textField = new TextField(randX, randY,
                        "Текстовое поле с координатами "+randX+":"+randY);
                addElem(textField);
                break;
        }
    }

    public static void addElementForEnteredCoordinates(int x, int y) throws CrossException {
        switch (random.nextInt(3)) {
            case (0):
                Button button = new Button(x, y, false);
                addElem(button);
                System.out.printf("Создана кнопка с координатами "+ x+":"+y+"\n");
                break;
            case (1):
                CheckBox checkBox = new CheckBox(x, y);
                addElem(checkBox);
                System.out.printf("Создан чекбокс координатами "+ x+":"+y+"\n");
                break;
            case (2):
                TextField textField = new TextField(x, y,
                        "Текстовое поле с координатами "+randX+":"+randY);
                addElem(textField);
                System.out.printf("Создано текстовое поле с координатами "+ x+":"+y+"\n");
                break;
        }
    }

    public static void randXY(){
        randX = random.nextInt(100);
        randY = random.nextInt(100);
        System.out.printf(" Координаты нового элемента " +randX+":"+randY+"\n");

    }

    public List<Rectangle> getAllElem(){
        return field;
    }



}
