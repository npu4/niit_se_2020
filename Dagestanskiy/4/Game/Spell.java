package Game;

import java.util.Arrays;

public class Spell {
    public final static int NUMBER_SPELLS = 3;
    public final static int NUMBER_TYPE_ACTION_SPELLS = 3;
    public final static int NUMBER_IMPACTS = 2;
    public final static int NUMBER_TYPE_ACTION_IMPACTS = 2;
    String name[] ;
    int power[];
    int type[] = new int[3] ;
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
            String name[] = new String[NUMBER_SPELLS];
            this.name = new String[]{
                    "Огненное касание", "Цепная молния", "Исцеление"};
            int power[] = new int[NUMBER_TYPE_ACTION_SPELLS];
            this.power = new int[] {-300,-100,200};
            this.type = new int[] {0,1,2};
        }
        if (nameClass.equals("Monster")) {
            String name[] = new String[NUMBER_IMPACTS];
            this.name = new String[]{
                    "Огненное касание", "Цепная молния", "Мигрень"};
            int power[] = new int[NUMBER_TYPE_ACTION_IMPACTS];
            this.power = new int[] {-300,-100, -200};
            this.type = new int[] {0,1,3};
        }
        this.namePerson = namePerson;
        this.nameClass = nameClass;
    }

    public void cast( int i){
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
