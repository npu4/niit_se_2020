package Game;

import java.util.Arrays;

import static Game.Game.*;

public class Scene {
    Person[] person;
    int personNumber;

    public Scene(Person[] p, int personNumber) {
        p = new Person[personNumber];

        for (int i = 0; i < personNumber; i++) {
            Integer z = rnd(0,2);
            if (z.equals(0)) {
                p[i]= null;
                continue;
            }
            if (z.equals(1)){
                p[i] = new Monster(i, "Monster"+Integer.toString(i));
            } else {
                p[i] = new Magician(i, "Magician"+Integer.toString(i));
            }
        }

        this.person = p;
        this.personNumber = personNumber;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "person=" + Arrays.toString(person) +
                ", personNumber=" + personNumber +
                '}';
    }
    public void scenePrint() {
        for (int i = 0; i < personNumber; i++) {
            if (!(person[i] ==null)){
                System.out.println("Позиция номер: "+i+" " + person[i].namePerson +
                        ", здоровье: " + person[i].health+".");}
            else System.out.println("Позиция номер: "+i+" пустая.");
        }
    }

    public void sceneFinishPrint(int stepCounter) {
        if(stepCounter<LIMIT_NUMBER_STEPS_GAME){
            for (int i = 0; i < personNumber; i++) {
                if (!(person[i] ==null)){
                    if(person[i].health > 0){
                        System.out.println("\nИгра закончилась за "+stepCounter+" ходов. " +"Победил " + person[i].namePerson +
                                " на позиции "+i+ ". Его здоровье: " + person[i].health+".");}
                }
            }
        } else {
            System.out.println("\nИгра прекращена. Превышен предел ходов игры: "+LIMIT_NUMBER_STEPS_GAME+". Победитель не определён.");
        }
    }

    public int counterActivePersons() {
        int c = 0;
        for (int i = 0; i < personNumber; i++) {
            if (!(person[i] ==null)){
                if(person[i].getHealth()>0){
                    c++;
                }
            }
        }
        return c;
    }

    public void setMascScene(boolean[]smc){
        for (int i = 0; i < NUMBER_POSITIONS; i++) {
            if (!(person[i] ==null)){
                smc[i] = true;
            } else {
                smc[i] = false;
            }
        }
    }

    public int startNumber(boolean[]sn){
        int z = NUMBER_POSITIONS-1;
        int stNumber = rnd(0,z);
        for (int i = 0; i < NUMBER_POSITIONS ; i++) {
            if (! sn[stNumber]) {
                if(stNumber < (NUMBER_POSITIONS-1)){
                    stNumber++;
                } else stNumber = 0;
            } else { break; }
        }
        return stNumber;
    }

    public int nextActionNumber(int actNum, boolean[]sn){
        int stNumber = actNum +1;
        if (stNumber>(NUMBER_POSITIONS-1)){
            stNumber = 0;
        }
        for (int i = 0; i < NUMBER_POSITIONS ; i++) {
            if (! sn[stNumber]) {
                stNumber++;
                if(stNumber>(NUMBER_POSITIONS-1)){
                    stNumber=0;
                }
            } else {
                if(person[stNumber].health>0){
                    break;} else {
                    stNumber++;
                    if (stNumber>(NUMBER_POSITIONS-1)){
                        stNumber = 0;
                    }
                }
            }
        }
        return stNumber;
    }

    public void stepGame(int actNum, boolean[]sn,int spellIndex, int spellPower){
        int spellType = person[actNum].spell.type[spellIndex];

       if (spellType==2) {
           person[actNum].health = person[actNum].health + spellPower;
           System.out.println(person[actNum].getNameClassRus()+" " + person[actNum].namePerson + " исцелился на " +
                   + spellPower+". Теперь у него "+person[actNum].health+ " здоровья.");
           return;
       }
       if (spellType==0){
           int stNumber = actNum+1;
           if (stNumber>NUMBER_POSITIONS-1){
               stNumber = 0;
           }
           String s ="";
           if (sn[stNumber]){
              if(person[stNumber].health>0){
                  person[stNumber].health = person[stNumber].health + spellPower;
                  if (person[stNumber].health<0){
                      person[stNumber].health = 0;

                  }
                  String s1 = person[actNum].spell.name[spellIndex]+ " ударяет по "+
                          person[stNumber].namePerson+ ", наносит урон " +
                          + spellPower+"." ;
                  if(person[stNumber].health>0){
                      s =" Теперь у " + person[stNumber].namePerson + " стало " +
                              person[stNumber].health+ " здоровья.";
                      System.out.println(s1 + s);

                  } else {
                      s = " "+person[stNumber].getNameClassRus()+" " +person[stNumber].namePerson+ " убит. " +
                              "Позиция "+Integer.toString(stNumber) +" стала пустой.";
                      System.out.println(s1);
                      System.out.println(" " + s);
                  }
              } else {
                  System.out.println(person[actNum].getNameClassRus()+" " + person[actNum].namePerson +
                          " нанес удар " +person[actNum].spell.name[spellIndex] + " по пустой позиции.");
              }
           } else {
               System.out.println(person[actNum].getNameClassRus()+" " + person[actNum].namePerson +
                       " нанес удар " +person[actNum].spell.name[spellIndex] + " по пустой позиции.");
           }
       }

        if (spellType==1){
            int stNumber = actNum+1;
            if (stNumber>NUMBER_POSITIONS-1){
                stNumber = 0;
            }
            String s = "";
            String sd = "";
            String snp = "";
            int stn = 0;
            int std = 0;
            for (int i = 0; i < NUMBER_POSITIONS-1 ; i++) {
                if (sn[stNumber]){
                    if(person[stNumber].health>0){
                        person[stNumber].health = person[stNumber].health + spellPower;
                        if (person[stNumber].health<=0){
                            person[stNumber].health = 0;
                            sd += " " + person[stNumber].namePerson;
                            snp+=" "+Integer.toString(stNumber);
                            std++;
                        }
                        s += " " + person[stNumber].namePerson;
                        stn++;
                    }
                }
                stNumber = stNumber +1;
                if (stNumber>NUMBER_POSITIONS-1){
                    stNumber = 0;
                }
            }

            if (stn>1) {
                System.out.println(person[actNum].spell.name[spellIndex] + " ударяет по "+s+
                        ". Каждый получает урон по " + spellPower+"." );
            }
            if(stn ==1) {
                System.out.println(person[actNum].spell.name[spellIndex] + " ударяет по "+s+
                        ". Он получает урон " + spellPower+"." );
            }
            if(stn < 1) {
                System.out.println(person[actNum].spell.name[spellIndex] + " ударяет по пустым позициям.");
            }
            if (std>1){
                System.out.println( sd+ " погибли. Позиции "+snp+" стали пустыми.");
            }
            if (std==1) {
                System.out.println( sd+ " погиб. Позиция" +snp+" стала пустой.");
            }
        }

        if (spellType==3){
            int stNumber = actNum+1;
            if (stNumber>NUMBER_POSITIONS-1){
                stNumber = 0;
            }
            String s = "";
            String sd = "";
            String snp = "";
            int stn = 0;
            int std = 0;
            for (int i = 0; i < NUMBER_POSITIONS-1 ; i++) {
                if (sn[stNumber]){
                    if(  person[stNumber].getNameClass().equals("Magician") & person[stNumber].health>0) {
                        person[stNumber].health = person[stNumber].health + spellPower;
                        if (person[stNumber].health<=0){
                            person[stNumber].health = 0;
                            sd += " " + person[stNumber].namePerson;
                            snp += " " + Integer.toString(stNumber);
                            std++;
                        }
                        s += " " + person[stNumber].namePerson;
                        stn++;
                    }
                }
                stNumber = stNumber +1;
                if (stNumber>NUMBER_POSITIONS-1){
                    stNumber = 0;
                }
            }
            if (stn>1) {
                System.out.println(person[actNum].spell.name[spellIndex] + " ударяет по "+s+
                        ". Каждый получает урон по " + spellPower+"." );
            }
            if(stn ==1) {
                System.out.println(person[actNum].spell.name[spellIndex] + " ударяет по "+s+
                        ". Он получает урон " + spellPower+"." );
            }
            if(stn < 1) {
                System.out.println(person[actNum].spell.name[spellIndex] + " ударяет по пустым позициям.");
            }
            if (std>1){
                System.out.println( sd+ " погибли. Позиции "+snp+" стали пустыми.");
            }
            if (std==1) {
                System.out.println( sd+ " погиб. Позиция" +snp+" стала пустой.");
            }
        }

        int stNumber = actNum +1;
        if (stNumber>(NUMBER_POSITIONS-1)){
            stNumber = 0;
        }
        for (int i = 0; i < NUMBER_POSITIONS ; i++) {
            if (! sn[stNumber]) {
                if(stNumber<(NUMBER_POSITIONS-1)){
                    stNumber++;
                } else stNumber = 0;
            } else { break; }
        }
    }


}
