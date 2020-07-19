import java.util.Random;

public class Game {

    Monster[] monsters;
    Mage[] mages;

    Game (int numberOfCharecter){
        monsters = new  Monster[numberOfCharecter/2];
        mages = new Mage[numberOfCharecter/2];
    }

    void createMonster(Integer monsterHp, String monsterName, int numberOfMonster){
        monsters[numberOfMonster]= new Monster (monsterHp, monsterName);
    }

    void createMage(Integer mageHp, String mageName, int numberOfMage){
        mages[numberOfMage]= new Mage (mageHp, mageName);
    }

    int findTarget(int position) {
        int per;
        per= (int)(Math.random() * 11);
        for (int i = 0; i < monsters.length; i++) {
            if ((monsters[i].position == per) && (monsters[i].position != position)&&monsters[i].hp>=0) {
                return per;
            }
        }
        for(int i = 0; i < mages.length; i++) {
            if ((mages[i].position == per) && (mages[i].position != position)&&mages[i].hp>=0) {
                return per;
            }
        }
        per =findTarget(position);
        return per;
    }


    void damageMonster(Monster monstr) {
        if(monstr.hp>=0 ) {
            int perPos = findTarget(monstr.position);
            for (int j = 0; j < monsters.length; j++) {
                if (monsters[j].position == perPos) {
                    monsters[j].hp = monsters[j].hp - monstr.monsterDamage;
                    System.out.println("Монстр " + monstr.name + " атакует монстра " +
                            monsters[j].name + " на " + monstr.monsterDamage + " единиц урона");
                }
            }
            for (int j = 0; j < mages.length; j++) {
                if (mages[j].position == perPos) {
                    mages[j].hp = mages[j].hp - monstr.monsterDamage;
                    System.out.println("Монстр " + monstr.name + " атакует мага " +
                            mages[j].name + " на " + monstr.monsterDamage + " единиц урона");
                }
            }
        }
    }


    void damageMageForeOneSpells(Mage mage, String nameSpell, int castValue) {
        int perPos = findTarget(mage.position);
        for (int j = 0; j < monsters.length; j++) {
            if (monsters[j].position == perPos) {
                monsters[j].hp = monsters[j].hp - castValue;
                System.out.println("Маг " + mage.name + " использует заклинание " +
                        nameSpell + " на монстра" + monsters[j].name + " и наносит " + castValue +" единиц урона");
            }

        }
        for (int j = 0; j < mages.length; j++) {
            if (mages[j].position == perPos) {
                mages[j].hp = mages[j].hp - castValue;
                System.out.println("Маг " + mage.name + " использует заклинание " +
                        nameSpell + " на мага" + mages[j].name + " и наносит " + castValue +" единиц урона");
            }
        }
    }

    void lightningChain(Mage mage, String nameSpell, int castValue){
        System.out.println("Маг " + mage.name + " использует заклинание " +
                nameSpell);
        for (int i = 0; i< monsters.length; i++) {
            if (monsters[i].hp > 0) {
                monsters[i].hp = monsters[i].hp - castValue;
                System.out.println("на монстра " + monsters[i].name + " и наносит " + castValue + " единиц урона");
            }
        }
            for (int i = 0; i < mages.length; i++) {
                if (mages[i].hp > 0 && mages[i] != mage) {
                    mages[i].hp = mages[i].hp - castValue;
                    System.out.println(" на мага" + mages[i].name + " и наносит " + castValue + " единиц урона");

                }
            }
        }

    void wallOfFire(Mage mage, String nameSpell, int castValue){
        int[] positionDamage = {0,2,4,8,10};
        System.out.println("Маг " + mage.name + " использует заклинание " +
                nameSpell);

        for(int j=0; j<positionDamage.length;j++){
            for(int i=0;i<monsters.length; i++){
                if (monsters[i].position==positionDamage[j]&&monsters[i].hp>=0){
                    monsters[i].hp=monsters[i].hp-castValue;
                    System.out.println( " на монстра" + monsters[i].name + " и наносит " + castValue +" единиц урона");
                }
            }
        }
        for(int j=0; j<positionDamage.length;j++){
            for(int i=0;i<mages.length; i++){
                if (mages[i].position==positionDamage[j]&&mages[i].hp>=0){
                    mages[i].hp=mages[i].hp-castValue;
                    System.out.println( " на мага" + mages[i].name + " и наносит " + castValue +" единиц урона");
                }
            }
        }

    }

    void expulsionOfMonsters(Mage mage, String nameSpell, int castValue){
        System.out.println("Маг " + mage.name + " использует заклинание " +
                nameSpell);
        for(int i=0;i<monsters.length;i++){
            if(monsters[i].hp>=0) {
                monsters[i].hp = monsters[i].hp - castValue;
                System.out.println(" на монстра " + monsters[i].name + " и наносит " + castValue + " единиц урона");
            }
        }
    }

    void migraine(Mage mage, String nameSpell, int castValue){
        System.out.println("Маг " + mage.name + " использует заклинание " +
                nameSpell);
        for(int i=0;i<mages.length;i++){
            if(mages[i].hp>=0) {
                mages[i].hp = mages[i].hp - castValue;
                System.out.println(" на мага" + mages[i].name + " и наносит " + castValue + " единиц урона");
            }
        }
    }


    void spellBookAndCastSpells(Mage mage){
        if(mage.hp>=0) {

            int perForCast = 0;
            String nameSpell;
            int castValue;

            perForCast =1+ (int)(Math.random() * 6);
            for (int i = 0; i < 3; i++) {
                if (perForCast == mage.numCast[i]) {
                    break;
                }
                if (perForCast != mage.numCast[i] && i == Mage.numberOfSpells - 1) {
                    i = 0;
                    perForCast =1+ (int)(Math.random() * 6);
                }
            }

            switch (perForCast) {
                case 1:
                    nameSpell = "hill";
                    castValue = 3;
                    mage.hp = mage.hp + castValue;
                    System.out.println("Маг " + mage.name + " использовал " +
                            nameSpell + " и излечил себя на " + castValue + " единиц здоровья");
                    break;
                case 2:
                    nameSpell = "lightningBolt";
                    castValue = 4;
                    damageMageForeOneSpells(mage, nameSpell, castValue);
                    break;
                case 3:
                    nameSpell = "lightningChain";
                    castValue = 2;
                    lightningChain(mage, nameSpell, castValue);
                    break;
                case 4:
                    nameSpell = "wallOfFire";
                    castValue = 8;
                    wallOfFire(mage, nameSpell, castValue);
                    break;
                case 5:
                    nameSpell = "expulsionOfMonsters";
                    castValue = 3;
                    expulsionOfMonsters(mage, nameSpell, castValue);
                    break;
                case 6:
                    nameSpell = "migraine";
                    castValue = 4;
                    migraine(mage, nameSpell, castValue);
                    break;
                default:
                    break;
            }
        }
    }

    void dead(){
        for(int i=0;i<mages.length;i++) {
            if (mages[i].hp < 0&&CharacterMain.NumberOfMage[i]>=0) {
                System.out.println("Маг " + mages[i].name + " убит ");
                CharacterMain.NumberOfMage[i]=-500;
                CharacterMain.numberOfCharecter = CharacterMain.numberOfCharecter - 1;
            }
        }
        for(int i=0;i<monsters.length;i++) {
            if (monsters[i].hp < 0 && CharacterMain.numberOfMonster[i] >= 0) {
                System.out.println("Монстр " + monsters[i].name + " убит ");
                CharacterMain.numberOfMonster[i] = -500;
                CharacterMain.numberOfCharecter = CharacterMain.numberOfCharecter - 1;
            }
        }
        if( CharacterMain.numberOfCharecter==1){
             for(int i=0;i<mages.length;i++) {
                 if (mages[i].hp >=0)
                     System.out.println("Победил маг " + mages[i].name );
             }
            for(int i=0;i<monsters.length;i++){
                if (monsters[i].hp >=0)
                    System.out.println("Победил монстр " + monsters[i].name );
            }
        }
    }
}



