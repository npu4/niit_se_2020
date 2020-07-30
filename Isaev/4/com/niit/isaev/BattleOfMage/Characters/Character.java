package com.niit.isaev.BattleOfMage.Characters;
import java.util.Random;

public class Character {

    int health;
    String name;
    int numberPosition;
    int[] positions = new int[10];
    int occupiedPositions = 0;
    Random random = new Random();

    public Character(String name) {
        this.name = name;
        this.choisePosition();
    }


    void choisePosition(){
      int tempPosition = random.nextInt(10);
      for(int i =0;i<=occupiedPositions;i++) {
          if (tempPosition == positions[i]) {
              tempPosition = random.nextInt(10);
              i = 0;
          }
        }
              numberPosition = tempPosition;
              positions[occupiedPositions] = numberPosition;
              occupiedPositions++;


      }

    public String getName() {
        return name;
    }

    public int getNumberPosition() {
        return numberPosition;
    }
}
