import java.util.Random;

public class Mage extends Character{
    static int numberOfSpells=3;
    int[] numCast= new int[numberOfSpells];


    Mage( Integer mageHp, String mageName){
        super(mageHp, mageName);
        for(int i=0; i<numberOfSpells; i++){
            numCast[i]= 1+ (int)(Math.random() * 6);
        }
    }

}
