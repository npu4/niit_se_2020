public class Monster extends Character{

    int monsterDamage;

    Monster( Integer monsterHp, String monsterName){
        super( monsterHp, monsterName);
        monsterDamage=(int)(Math.random()*5+1);
    }




}
