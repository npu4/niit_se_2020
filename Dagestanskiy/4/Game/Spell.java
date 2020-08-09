package Game;

import java.util.Arrays;

public class Spell {
    String[] name;
    int[] power;
    int[] type = new int[3] ;
/*
    type = 0; - удар по  следующей позиции
    type = 1; - удар всех действующих персонажжей кроме себя
    type = 2; - воздействие на себя (исцеление)
    type = 3; - удар по всем магам (кроме себя)

*/
    String namePerson;
    String nameClass;

    public Spell(String namePerson, String nameClass) {
        if (nameClass.equals("Magician")) {
            this.name = new String[]{
                    "Огненное касание", "Цепная молния", "Исцеление"};
            this.power = new int[] {-300,-100,200};
            this.type = new int[] {0,1,2};
        }
        if (nameClass.equals("Monster")) {
            this.name = new String[]{
                    "Огненное касание", "Цепная молния", "Мигрень"};
            this.power = new int[] {-300,-100, -200};
            this.type = new int[] {0,1,3};
        }
        this.namePerson = namePerson;
        this.nameClass = nameClass;
    }

    public void sayCast( int i){
        if (nameClass.equals("Magician")){
            System.out.println("Маг "+namePerson+" произносит заклинание " + name[i]+".");
        }
        if (nameClass.equals("Monster")){
            System.out.println("Монстр "+namePerson+" наносит удар " + name[i]+".");
        }
    }

    @Override
    public String toString() {
        return "Spell{" +
                "name=" + Arrays.toString(name) +
                ", power=" + Arrays.toString(power) +
                '}';
    }
}
