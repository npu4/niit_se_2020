public class CharacterMain {

     static int numberOfCharecter = 4;
     static int[] numberOfMonster= {0,1};
     static int[] NumberOfMage={0,1};


    public static void main(String[] args) {

        Game q1 = new Game(numberOfCharecter);

        q1.createMonster(12, "q1",0 );
        q1.createMonster(12, "q2", 1 );

        q1.createMage(12, "q3",0 );
        q1.createMage(12, "q4",1);



        int raund=1;

        while(numberOfCharecter>1){
            System.out.println("Раунд " +raund);
            q1.damageMonster(q1.monsters[0]);
            q1.damageMonster(q1.monsters[1]);
            q1.spellBookAndCastSpells(q1.mages[0]);
            q1.spellBookAndCastSpells(q1.mages[1]);
            q1.dead();
            raund++;
        }


    }

}
