package battle.characters;

import java.util.Random;

public class Monster extends Character {
    private final int ATTACK_DAMAGE;

    public Monster(int position, int health, String name) {
        this.position = position;
        this.health = health;
        this.name = name;
        ATTACK_DAMAGE = new Random().nextInt(1) + 4;
    }

    @Override
    public void attack(Character[] characters) {
        int targetPosition;
        while (true) {
            targetPosition = new Random().nextInt(characters.length);

            if (characters[targetPosition] != this && characters[targetPosition] != null) {
                characters[targetPosition].setHealth(characters[targetPosition].getHealth() - ATTACK_DAMAGE);
                System.out.printf("%s атакует %s и наносит %d урона\n\n", this.getName(), characters[targetPosition].getName(), ATTACK_DAMAGE);
                break;
            }
        }

        isTargetDead(characters, targetPosition);
    }
}
