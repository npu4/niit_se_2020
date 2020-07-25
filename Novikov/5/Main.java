import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        UI q1=new UI();

        Button Button1 = new Button(17, 5, true);
        TextField text1= new TextField(15, 2, "Координата x для нового элемента", "0");
        TextField text2= new TextField(7, 3, "Координата y для нового элемента", "0");
        Button1.click(Integer.parseInt(text1.getText()), Integer.parseInt(text2.getText()));

        for(int i=0; i<10;i++) {

            text1.newTextConvertIntToString(random.nextInt(100));
            text2.newTextConvertIntToString(random.nextInt(100));
            Button1.click(Integer.parseInt(text1.getText()), Integer.parseInt(text2.getText()));
        }

        System.out.println(q1.getAllElem() + "\n");


        for(int i=1; i<q1.getAllElem().size();i++){
            Rectangle r = q1.getAllElem().get(i);
            if (r instanceof CheckBox) {
                ((Clickable) q1.getAllElem().get(i)).click();
                System.out.println(((CheckBox) r).press());
            }
            if (r instanceof Button) {
                if(i==random.nextInt(q1.getAllElem().size()-1))
                    r.setOnOff(false);
                ((Button) r).click();
            }
        }

    }




    }

