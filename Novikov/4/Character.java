


public class Character {

    Integer hp;
    String name;
    int position;

    static int[] map= new int[10];
    static int mapPosition=0;

    Character( Integer hp, String name){
        this.hp=hp;
        this.name=name;
        this.createPosition();
    }


    void createPosition(){
        int per;
        per = (int)(Math.random()*11);
        for(int i=0; i<=mapPosition; i++){
            if(map[i]==(per)) {
                per = (int) (Math.random() * 11);
                i = 0;
            }
        }
        position=per;
        map[mapPosition]=position;
        mapPosition++;
    }



}
