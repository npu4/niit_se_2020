package Game;

public class Person {
    int positionNumber;
    String namePerson;
    int health;
    Spell spell;

    public Person(int positionNumber, String namePerson) {
        this.positionNumber = positionNumber;
        this.namePerson = namePerson;
        this.health = health;
        this.spell = spell;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(int positionNumber) {
        this.positionNumber = positionNumber;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getNameClass(){
        return "Person";
    }
    public String getNameClassRus(){
        return "Персонаж";
    }

    @Override
    public String toString() {
        return "Person{" +
                "positionNumber=" + positionNumber +
                ", namePerson='" + namePerson + '\'' +
                ", health=" + health +
                '}';
    }
}

class Monster extends Person {
    public static final int START_HEALTH_MONSTER = 1000;

    public Monster(int positionNumber, String namePerson) {
        super(positionNumber, namePerson);
        this.health = START_HEALTH_MONSTER;
        this.spell = new Spell(this.namePerson, "Monster");
    }

    public String getNameClass(){
        return "Monster";
    }
    public String getNameClassRus(){
        return "Монстр";
    }

    @Override
    public String toString() {
        return "Monster{" +
                "positionNumber=" + positionNumber +
                ", namePerson='" + namePerson + '\'' +
                ", health=" + health +
                ", spell=" + spell +
                '}';
    }
}



class Magician extends Person {
    public static final int START_HEALTH_MAGICIAN = 800;

    public Magician(int positionNumber, String namePerson) {
        super(positionNumber, namePerson);
        this.health = START_HEALTH_MAGICIAN;
        this.spell = new Spell(this.namePerson, "Magician");

    }

    public String getNameClass(){
        return "Magician";
    }
    public String getNameClassRus(){
        return "Маг";
    }

    @Override
    public String toString() {
        return "Magician{" +
                "positionNumber=" + positionNumber +
                ", namePerson='" + namePerson + '\'' +
                ", health=" + health +
                ", spell=" + spell +
                '}';
    }
}
