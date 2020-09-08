package BattleGame;

public class Character {
    private int position;   // Позиция персонажа на сцене
    private int health;     // Здоровье персонажа
    private String name;    // Имя персонажа
    private String type;    // Тип персонажа

    Character(int position, String name, String type, int health){
        this.position   =   position;
        this.health     =   health;
        this.name       =   name;
        this.type       =   type;
    }

    void attack(Character[] battlers){}


    public void setPosition(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean isDead(){
        return getHealth() <= 0;
    }
}
